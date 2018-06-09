package com.why.project.popupwindowmenuutildemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.why.project.popupwindowmenuutildemo.popupwindowMenu.PopUpMenuBean;
import com.why.project.popupwindowmenuutildemo.popupwindowMenu.PopupWindowMenuUtil;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

	/**更多图标*/
	private ImageView mMoreImg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initViews();
		initEvents();
	}

	private void initViews() {
		mMoreImg = (ImageView)findViewById(R.id.moreImg);
	}

	private void initEvents() {
		mMoreImg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				openMenu();//弹出更多操作的menu列表
			}
		});
	}

	//弹出更多操作的menu列表
	private void openMenu(){
		final ArrayList<PopUpMenuBean> menuList = new ArrayList<PopUpMenuBean>();

		PopUpMenuBean popUpMenuBean = new PopUpMenuBean();
		popUpMenuBean.setImgResId(R.drawable.nav_menu_share);
		popUpMenuBean.setItemStr("分享");
		menuList.add(popUpMenuBean);

		PopUpMenuBean popUpMenuBean1 = new PopUpMenuBean();
		popUpMenuBean1.setImgResId(R.drawable.nav_menu_fabu);
		popUpMenuBean1.setItemStr("发布");
		menuList.add(popUpMenuBean1);

		PopupWindowMenuUtil.showPopupWindows(MainActivity.this, mMoreImg, menuList, new PopupWindowMenuUtil.OnListItemClickLitener() {
			@Override
			public void onListItemClick(int position) {
				//如果position == -1，预留位，用来标明是点击弹出框外面的区域
				if(position != -1) {
					if(menuList.get(position).getItemStr().equals("发布")){
						Toast.makeText(MainActivity.this,"发布",Toast.LENGTH_SHORT).show();
					}else if(menuList.get(position).getItemStr().equals("分享")){
						Toast.makeText(MainActivity.this,"分享",Toast.LENGTH_SHORT).show();
					}
				}
			}
		});
	}
}
