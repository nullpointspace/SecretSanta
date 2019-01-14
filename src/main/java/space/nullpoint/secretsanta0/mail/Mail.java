package space.nullpoint.secretsanta0.mail;

import space.nullpoint.secretsanta0.model.User;

import java.util.List;

public class Mail {
    private static final String text = "Привет, <User>! \n" +
            "Поздравляем тебя с наступающим Новым Годом и желаем исполнения твоих самых заветных грёз и мечтаний. \n" +
            "В этом году ты станешь самым настоящим Сантой. \n" +
            "<Ward>, еще не знает, но очень ждёт от тебя новогоднего волшебства! \n" +
            "\n" +
            "Если до 7 января твой санта не объявится, напиши мне или подойди к Алёне";

    public static void sendAllMail(List<User> users){
        int i=1;
        for (User user : users){
            Sender.send(text.replace("<User>", user.getName()).replace("<Ward>", user.getWard().getName()), user.getEmail());
            System.out.println("Отправлено писем " + i++ + " из " + users.size());
        }
    }
}
