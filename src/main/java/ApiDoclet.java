import com.sun.javadoc.*;

/**
 * test class
 *
 * @author : yu.zhang
 * @date : 2022/10/19 2:06 PM
 * Email : zephyrjung@126.com
 **/
public class ApiDoclet extends Doclet {
    /**
     * testInteger
     * @example 1
     */
    private Integer testInteger;
    /**
     * testString
     */
    private final static String testString = "aaa";

    /**
     * test method
     *
     * @param root root参数
     * @return 啊啊啊啊
     */
    public static boolean start(RootDoc root) {
        ClassDoc[] classDocs = root.classes();
        for (ClassDoc cls : classDocs) {
            System.out.println("Cls:> " + cls.commentText());
            for (Tag tag : cls.tags("author")) {
                System.out.println("author:>" + tag.text());
            }
            MethodDoc[] methodDocs = cls.methods();
            for (MethodDoc methodDoc : methodDocs) {
                System.out.println("Mth:>" + methodDoc.commentText());
                for (Tag tag : methodDoc.tags("param")) {
                    System.out.println("param:>" + tag.text());
                }
            }
            FieldDoc[] fieldDocs = cls.fields();
            for (FieldDoc fieldDoc : fieldDocs) {
                System.out.println("Fld:>" + fieldDoc.commentText());
//                System.out.println(fieldDoc.tags("example")[0].text());
            }
        }
        return true;
    }

    /**
     * test method
     *
     * @param args 参数列表
     */
    public static void main(String[] args) {
        String[] docArgs = new String[]{"-doclet", ApiDoclet.class.getName(), "/Users/zephyrjung/Documents/GithubSpace/ApiDoclet/src/main/java/ApiDoclet.java"};
        com.sun.tools.javadoc.Main.execute(docArgs);
        String[] docArgs1 = new String[]{"-doclet", ApiDoclet.class.getName(), "/Users/zephyrjung/Documents/GithubSpace/ApiDoclet/src/main/java/TestEnum.java"};
        com.sun.tools.javadoc.Main.execute(docArgs1);
        String[] docArgs2 = new String[]{"-doclet", ApiDoclet.class.getName(), "/Users/zephyrjung/Documents/GithubSpace/ApiDoclet/src/main/java/TestInterface.java"};
        com.sun.tools.javadoc.Main.execute(docArgs2);
    }
}
