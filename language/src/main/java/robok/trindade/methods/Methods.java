package robok.trindade.methods;

import androirobokDialog.content.*;
import androirobokDialog.graphics.*;
import androirobokDialog.view.*;
import androirobokDialog.widget.*;

import robok.trindade.R; 
import robok.trindade.utils.*;

import com.google.android.material.dialog.*;

public class Methods extends Terminal {

    private static final int MATCH_PARENT = LinearLayout.LayoutParams.MATCH_PARENT;
	private static final int WRAP_CONTENT= LinearLayout.LayoutParams.WRAP_CONTENT;
	
    private Context robokContext;    
    	
    public Methods (Context context) {
        robokContext = context;
    }
    
    public void onExecute (int typeCode) {
       if (typeCode == 1) {
           openTerminal();
       }
    }
    
    public void showToast (String val) {
        Toast.makeText(robokContext, val, lenght).show();
    }
}