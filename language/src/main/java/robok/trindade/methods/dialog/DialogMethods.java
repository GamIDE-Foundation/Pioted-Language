package robok.trindade.methods.dialog;

import android.content.*;
import android.graphics.*;
import android.view.*;
import android.widget.*;

import robok.trindade.R; 
import robok.trindade.util.*;

import com.google.android.material.dialog.*;

public class DialogMethods {

    private static final int MATCH_PARENT = LinearLayout.LayoutParams.MATCH_PARENT;
	private static final int WRAP_CONTENT= LinearLayout.LayoutParams.WRAP_CONTENT;
	
    private Context robokContext;
    private RobokTerminal robokTerminal;
    private TextUtil textUtil;
    	
    public DialogMethods (Context context) {
        robokContext = context;
        robokTerminal = new RobokTerminal(context);
        textUtil = new TextUtil(context);
    }
    
    public void onExecute (int typeCode) {
       if (typeCode == 1) {
          robokTerminal.openTerminal();
       }
    }
    
	public void showDialog (String title, String message){
	    var t = textUtil.formatSpaces(title);
	    var m = textUtil.formatSpaces(message);
		MaterialAlertDialogBuilder robokDialog = new MaterialAlertDialogBuilder(robokContext);
		robokDialog.setTitle(textUtil.formatWordWrap(t));
	    robokDialog.setMessage(textUtil.formatWordWrap(m));
		robokDialog.setPositiveButton("OK", null);
		robokDialog.show();
		onExecute(0);
	}
}