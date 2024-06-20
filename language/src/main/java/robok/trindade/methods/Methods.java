package robok.trindade.methods;

import android.content.*;
import android.graphics.*;
import android.view.*;
import android.widget.*;

import robok.trindade.R; 
import robok.trindade.utils.*;

import com.google.android.material.dialog.*;

public class Methods {

    private static final int MATCH_PARENT = LinearLayout.LayoutParams.MATCH_PARENT;
	private static final int WRAP_CONTENT= LinearLayout.LayoutParams.WRAP_CONTENT;
	
    private Context robokContext;
    
    private RobokTerminal robokTerminal;
    	
    public Methods (Context context) {
        robokContext = context;
        robokTerminal = new RobokTerminal(context);
    }
    
    public void onExecute (int typeCode) {
       if (typeCode == 1) {
          robokTerminal.openTerminal();
       }
    }
    
    public void showToast (String val) {
        Toast.makeText(robokContext, val, lenght).show();
    }
}