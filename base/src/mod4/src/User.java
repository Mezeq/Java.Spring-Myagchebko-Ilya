import java.io.Serializable;
import java.util.List;

class User implements Serializable { private String name;private String login;private int age;private List<String> hobbies;

    public User(String name, String login, int age, List<String> hobbies) {
        this.name = name;
        this.login = login;
        this.age = age;
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Пользователь: ").append(name)
                .append(" с логином ").append(login)
                .append(". Его возраст ").append(age)
                .append(". Все увлечения:\n");

        for (String hobby : hobbies) {
            stringBuilder.append("- ").append(hobby).append("\n");
        }
        return stringBuilder.toString();
    }
}
