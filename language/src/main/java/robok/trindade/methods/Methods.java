package robok.trindade.methods;

import android.content.*;
import android.graphics.*;
import android.view.*;
import android.widget.*;

import robok.trindade.R; 
import robok.trindade.util.*;

import com.google.android.material.dialog.*;

public class Methods {

    private static final int MATCH_PARENT = LinearLayout.LayoutParams.MATCH_PARENT;
	private static final int WRAP_CONTENT= LinearLayout.LayoutParams.WRAP_CONTENT;
	
    private Context robokContext;
    private RobokTerminal robokTerminal;
    private TextUtil textUtil;
    	
    public Methods (Context context) {
        robokContext = context;
        robokTerminal = new RobokTerminal(context);
        textUtil = new TextUtil(context);
    }
    
    public void onExecute (int typeCode) {
       if (typeCode == 1) {
          robokTerminal.openTerminal();
       }
    }
    
    public void openTerminal() {
        onExecute(1);
    }
    
    public void showToast (String val) {
        var t_val = textUtil.formatSpaces(val);
        Toast.makeText(robokContext, textUtil.formatWordWrap(t_val);, 4000).show();
    }
}