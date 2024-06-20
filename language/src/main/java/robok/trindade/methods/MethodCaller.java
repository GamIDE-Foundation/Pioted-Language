package robok.trindade.methods;

import android.content.*;
import android.widget.*;
import android.graphics.*;

import robok.trindade.methods.view.ViewMethods;
import robok.trindade.methods.dialog.DialogMethods;
import robok.trindade.util.RobokTerminal;
import robok.trindade.util.TextUtil;

import java.lang.ref.*;
import java.lang.reflect.*;
import java.util.*;

public class MethodCaller {

    private Map<String, Method> methodsMap;
    private Context context;
    
    private Methods methodsInstance;
    private ViewMethods viewMethodsInstance;
    private DialogMethods dialogMethodsInstance;
    private RobokTerminal terminalMethodsInstance;
    
    public MethodCaller(Context context) {
        methodsMap = new HashMap<>();
        this.context = context;
        methodsInstance = new Methods(context);
        viewMethodsInstance = new ViewMethods(context);
        dialogMethodsInstance = new DialogMethods(context);
        terminalMethodsInstance = new RobokTerminal(context);
        try {
            methodsMap.put("showToast", Methods.class.getDeclaredMethod("showToast", String.class));
            methodsMap.put("createButton", ViewMethods.class.getDeclaredMethod("createButton", String.class, String.class));
            methodsMap.put("createText", ViewMethods.class.getDeclaredMethod("createText", String.class, String.class));
            methodsMap.put("openTerminal", RobokTerminal.class.getDeclaredMethod("openTerminal"));
			methodsMap.put("showDialog", DialogMethods.class.getDeclaredMethod("showDialog", String.class, String.class));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public void callMethod(int type, String methodName,  Object... args) {
        Method method = methodsMap.get(methodName);
        if (method != null) {
            try {
                switch (type) {
                    case 0:
                         method.invoke(methodsInstance, args);
                    case 1:
                         method.invoke(viewMethodsInstance, args);
                    case 2:     
                         method.invoke(dialogMethodsInstance, args);
                    case 4:
                         method.invoke(terminalMethodsInstance, args);
                }
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(context, "Erro ao chamar método '" + methodName + "'.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(context, "Método '" + methodName + "' não encontrado.", Toast.LENGTH_SHORT).show();
        }
    }
}
