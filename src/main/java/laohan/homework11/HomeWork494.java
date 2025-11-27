package laohan.homework11;

/**
 * @author wb
 * @date 2025/11/18 17:17
 */
public class HomeWork494 {
    public static void main(String[] args) {
        User wan = new User("wan", "12345a", "dada@sddafa.");
        try {
            userRegister(wan);
            System.out.println("用户"+wan.getName()+"注册成功！");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());;
        }

    }

    public static void userRegister(User user){
        String name=user.getName();
        if (!(user.getName().length()>=2&&user.getName().length()<=4)){
            throw new RuntimeException("用户名长度应在2和4之间！");
        }
        String pwd=user.getPassword();
        if (!(pwd.length()==6&&isDigital(pwd))){
            throw new RuntimeException("用户密码应为6为且为数字！");
        }

        String email = user.getEmail();
        int i = email.indexOf('@');
        int j = email.indexOf('.');
        if (!(i>0&&j>i)){
            throw new RuntimeException("邮箱中要包含@和.，且@在.之前");
        }

    }

    public static boolean isDigital(String str){
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]<'0'||chars[i]>'9'){
                return false;
            }
        }
        return true;
    }
}
class User{
    private String name;
    private String password;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }
}


