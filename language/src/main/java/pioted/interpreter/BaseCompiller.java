package pioted.interpreter;

import android.content.*;
import android.widget.*;

import pioted.methods.*;

public class BaseCompiller {
	
	String[] parts;
	MethodCaller methodCaller;
	Context context;
	
	
	public BaseCompiller(Context context){
		this.context = context;
        methodCaller = new MethodCaller(context);
	}
	
	public void compile(String codeToRun){
		String codeText = codeToRun;
		parts = codeText.split(" ");
		if (methodTyped("createButton")) {
			methodCaller.callMethod(parts[0], parts[1], parts[2]);
	    } else if (methodTyped("createText")) {
			methodCaller.callMethod(parts[0], parts[1], parts[2]);
		} else if (methodTyped("showToast")) {
			methodCaller.callMethod(parts[0], parts[1], parts[2]);
		} else if (methodTyped("openTerminal")) {
			methodCaller.callMethod(parts[0]);
		} else if (methodTyped("showDialog")) {
			methodCaller.callMethod(parts[0], parts[1], parts[2]);
		} else {
			Toast.makeText(context, "Nenhum método encontrado", 4000).show();
		}
	}
	
	public boolean methodTyped(String methodName){
		boolean returnVal;
		if (parts[0].contains(methodName)) {
			returnVal = true;
			} else {
			returnVal = false;
		}
		return  returnVal;
	}	
}