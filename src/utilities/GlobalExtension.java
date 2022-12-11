package utilities;

import gen.ToorlaParser;

import java.util.List;

public class GlobalExtension {
    public static boolean isEntryClass(List<ToorlaParser.MethodDeclarationContext> methods) {
        for (var method : methods) {
            var hitPublicMethod = method.methodAccessModifier.getText().equals("public");
            var hitIntReturnType = method.t == null ? false : method.t.st.getText().equals("int");
            var hitNullableParameters = method.param1 == null && method.param2 == null;
            var hitMainMethodName = method.methodName.getText().equals("main");

            if (hitPublicMethod && hitIntReturnType && hitNullableParameters && hitMainMethodName)
                return true;
        }

        return false;
    }

    public static void prepareParameterList(ToorlaParser.MethodDeclarationContext ctx) {
//        System.out.println();
        if (ctx.param1 == null && ctx.param2 == null) {
            System.out.printf(tabbedString(3) + "parameter list: []");
        } else if (ctx.param1 != null && ctx.param2 != null) {
            System.out.printf(tabbedString(3) + "parameter list: [type: %s / name: %s], [type: %s / name: %s]", ctx.typeP1.getText(), ctx.param1.getText(), ctx.typeP2.getText(), ctx.param2.getText());
        } else {
            if (ctx.param1 != null) {
                System.out.printf(tabbedString(3) + "parameter list: [type: %s / name: %s]", ctx.typeP1.getText(), ctx.param1.getText());
            } else {
                System.out.printf(tabbedString(3) + "parameter list: [type: %s / name: %s]", ctx.typeP2.getText(), ctx.param2.getText());
            }
        }
        System.out.println();
    }

    public static String tabbedString(int count) {
        return "\t".repeat(count);
    }
}
