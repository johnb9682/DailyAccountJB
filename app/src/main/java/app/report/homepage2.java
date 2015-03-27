package app.report; 

import android.app.Activity;  
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;  
import android.util.Log;
import android.view.DragEvent;
import android.view.GestureDetector;  
import android.view.GestureDetector.OnGestureListener;  
import android.view.MotionEvent;  
import android.view.View;  
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;  
import android.widget.ImageView;  
import android.widget.LinearLayout;
import android.widget.ViewFlipper;  
  
/** 
 * ViewFlipper实现水平滑动图片 
 * @author john bi
 * image -> clicked -> ontouch() -> gestureDetector -> onfiling 
 *  
 */  


public class homepage2 extends Activity implements OnGestureListener, OnClickListener,  OnTouchListener 
{  
    private ViewFlipper viewFlipper;  
    private ViewFlipper viewFlipper_sub;  
    private GestureDetector gestureDetector;  
    private View text_account,text_report,text_plan,text_about,text_exit;
    private LinearLayout home_img_bn_Layout, style_img_bn_layout, cam_img_bn_layout, shopping_img_bn_layout, show_img_bn_layout;
      
    // 声明图片资源数组  
    private int[] imageResIds = { R.drawable.account, R.drawable.exit,R.drawable.about,
    		R.drawable.plan,R.drawable.scroll }; 
    // All picture is setted by 300 *300
    //Small size is 150 *150
  
    @Override  
    public void onCreate(Bundle savedInstanceState) 
    {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.homepage3);  
        Log.i("goes in", "Continue!");
        //viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);  
          
        gestureDetector = new GestureDetector(this);  
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);  
        viewFlipper_sub = (ViewFlipper) findViewById(R.id.viewFlipper_sub); 
        
        text_account = this.findViewById(R.id.text_newaccount);
        text_report = this.findViewById(R.id.text_monthlyreport);
        text_plan = this.findViewById(R.id.text_plan);
        text_about = this.findViewById(R.id.text_about);
        text_exit = this.findViewById(R.id.text_exit);
  
        home_img_bn_Layout = (LinearLayout) findViewById(R.id.bottom_home_layout_ly);
        home_img_bn_Layout.setOnClickListener(clickListener_home);
        
        for (int i = 0; i < imageResIds.length; i++) 
        {  
            viewFlipper.addView(addImageView(i));  
            viewFlipper_sub.addView(addImageView((i+imageResIds.length-1)%imageResIds.length));
        }  
  
        Animation animation =AnimationUtils.loadAnimation(this, R.anim.extend);
        text_account.setAnimation(animation);
    }  
      
    /** 
     * 为ViewFlipper添加图片视图 
     */  
    private View addImageView(int position) 
    {  
        ImageView imageView = new ImageView(this);  
        imageView.setImageResource(imageResIds[position]);  
        //imageView.setAlpha(125);
        //imageView.isClickable();
        imageView.setOnClickListener(this);
        /*set the image is clickable
        goes to onclick method*/ 
        imageView.setOnTouchListener(this);
        /*set the image is touchable
         * goes to onTouch method 
         * then goes to onfling method
         */
        return imageView;  
    }  
  
    
    
    
    @Override  
    public boolean onDown(MotionEvent e) 
    {  /*
    	Log.i("image Clicked", "Down!");
    	for(int i = 0;i<3;i++)
    	{
    		View v = viewFlipper.getCurrentView();
    		if(viewFlipper.findViewById(imageResIds[i]) == v)
    		{
    			Log.i("image found", "Down!");
    		}
            
    	}*/
        return false;  
    }  
  
    @Override  
    public void onShowPress(MotionEvent e) {  
    }  
  
    @Override  
    public boolean onSingleTapUp(MotionEvent e) {  
        return false;  
    }  
  
    @Override  
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) 
    {  
        return false;  
    }  
  
    @Override  
    public void onLongPress(MotionEvent e) 
    {  
    }  
  
    /** 
     * 手指滑动事件回调方法 
     */  
    @Override  
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) 
    {  
        if(e1.getY() - e2.getY() > 100.0f) 
        { // 向左（前）滑动，显示下一张图片  
              
            viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_up_out)); 
            viewFlipper.showNext(); 
            viewFlipper.showPrevious();
            viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_up_in));
            //viewFlipper.setAlpha(125);
            viewFlipper.showNext();  
            
            viewFlipper_sub.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_up_out)); 
            viewFlipper_sub.showNext(); 
            viewFlipper_sub.showPrevious();
            viewFlipper_sub.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_up_in));
            //viewFlipper_sub.setAlpha(125);
            viewFlipper_sub.showNext();  
            displayText();
            return true;  
        } 
        else 
        {
        	if(e1.getY() - e2.getY() < -100.0f) 
        	{ 
        		// 向后（右）滑动，显示上一张图片  
        		viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_down_out));  
                viewFlipper.showPrevious();  
                viewFlipper.showNext();
                viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_down_in));
                viewFlipper.showPrevious();  
                
                viewFlipper_sub.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_down_out));  
                viewFlipper_sub.showPrevious();  
                viewFlipper_sub.showNext();
                viewFlipper_sub.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_down_in));
                viewFlipper_sub.showPrevious(); 
                displayText();
                return true;  
            }  
        }
        
        //Log.d("onfiling", "Continue");
        return false;  
    }  
      
    private void displayText() 
    {
	 	// TODO Auto-generated method stub
    	Log.i("Extend", "Continue");
	    int i = viewFlipper.getDisplayedChild();
	    Animation animation =AnimationUtils.loadAnimation(this, R.anim.extend);
	    switch(i)
	    {
	     case 0:
	    	 //new account
			 
			 text_account.setAnimation(animation);
			 break;
	     case 1:
	    	 //exit
			 text_exit.setAnimation(animation);
			 break;
	     case 2:
	    	 //about
			 text_about.setAnimation(animation);
		     break;
	     case 3:
	    	 //set my plan
	    	 text_plan.setAnimation(animation);
	    	 break;
	     case 4:
	    	 //monthly report
	    	 text_report.setAnimation(animation);
	    	 break;
		 default:
			 break;
	    	
	    }
	}

	/** 
     * 将当前Activity的触摸事件回调方法指派由gestureDetector对象进行调度 
     */  
    @Override  
    public boolean onTouchEvent(MotionEvent event) 
    {  
        return gestureDetector.onTouchEvent(event);  
    }

	@Override
	public void onClick(View v) 
	{
		// TODO Auto-generated method stub
		 Log.i("image Clicked", "Down!");
		 switch(viewFlipper.getDisplayedChild())
		 {
		     case 0:
		    	 //new account
		    	 openNewGameDialog();
		    	 /*
		    	 Intent i = new Intent(this,newAccount.class);
	    	     startActivity(i);
	    	     */
    			 break;
		     case 1:
		    	 //exit
		    	 finish();
     			 break;
		     case 2:
		    	 Intent k = new Intent(this, about.class);
	    	     startActivity(k);
		    	 //about
			     break;
		     case 3:
		    	 //set my plan
		    	 Intent l = new Intent(this, ListItem.class);//MyPlan.class);
	    	     startActivity(l);
		    	 break;
		     case 4:
		    	 //monthly report
		    	 Intent t = new Intent(this,monthReport.class);
	    	     startActivity(t);
		    	 break;
			 default:
				 break;
		 }
		 
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) 
	{
		// TODO Auto-generated method stub
		Log.d("onTouching", "Continue");
		return gestureDetector.onTouchEvent(event);
	};  

	private void openNewGameDialog()
    {
    	new AlertDialog.Builder(this)
    	.setTitle(R.string.choosecategory).setItems(R.array.difficulty,
    	 new DialogInterface.OnClickListener()
    	{
    		public void onClick(DialogInterface dialoginterface, int i)
    		{
    			//int diff = getIntent().getIntExtra(KEY_DIFFICULTY,INCOME);
    			startGame(i);
    		}
    	}).show();
    }
    
    private void startGame(int i)
    {
    	//Log.d(TAG,"clicked on "+i);
    	Intent intent = new Intent(homepage2.this,category.class);
    	//startActivity(i);
    	intent.putExtra(category.KEY_DIFFICULTY, i);
    	startActivity(intent);
    }
    
    // It is the listener of the button clickListener_home
    private OnClickListener clickListener_home = new OnClickListener() 
    {
		

		public void onClick(View v) 
		{
			// TODO Auto-generated method stub 
			start_intent();
			
			
		}

		
	};
	
	private void start_intent() 
	{
		// TODO Auto-generated method stub
		Intent i = new Intent(this, about.class);
		startActivity(i);
	}
} 