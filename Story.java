public class Story {
    private Situation start_story;
    public Situation current_situation;
    Story() {
        start_story = new Situation(
                "первая сделка (Windows)",
                "Только вы начали работать и тут же удача! Вы нашли клиента и продаете ему "
                        + "партию ПО MS Windows. Ему в принципе достаточно взять 100 коробок версии HOME.\n"
                        + "(1)у клиента денег много, а у меня нет - вы выпишете ему счет на 120 коробок ULTIMATE по 50тр\n"
                        + "(2)чуть дороже сделаем, кто там заметит - вы выпишете ему счет на 100 коробок PRO по 10тр\n"
                        + "(3)как надо так и сделаем - вы выпишете ему счет на 100 коробок HOME по 5тр ",
                3, 0, 0, 0);
        start_story.direction[0] = new Situation(
                "корпоратив",
                "Неудачное начало, ну что ж, сегодня в конторе корпоратив! "
                        + "Познакомлюсь с коллегами, людей так сказать посмотрю, себя покажу\n"
                        + "(1) пойду познакомлюсь с людьми в здании\n"
                        +"(2) пойду познакомлюсь с людьми на улице",
                2, 0, -10, -10);
        start_story.direction[0].direction[0] = new Situation(
                "Сяду за застолье",
                "На столе много вкусной еды\n"
                +"(1)Наброситься на еду\n"
                +"(2)Поговорить с сотрудниками",
                2,0,-10,-1);
        start_story.direction[0].direction[0].direction[0] = new Situation(
                "Вы съели всю самую вкусную еду",
                "Вас осуждают колеги",
                0,0,-10,-30);
        start_story.direction[0].direction[0].direction[1] = new Situation(
                    "Вы решили поговорить с сотрудниками",
                "Вы нашли новых друзей",
                0, 0, -10, 15);
        start_story.direction[0].direction[1] = new Situation(
                    "Вы вышли на улицу",
                "(1)Подойти к барбекю\n"
                    +"(2)Подойти к группе у басейна",
                2,0,-10,-10);
        start_story.direction[0].direction[1].direction[0] = new Situation(
                "Вы подошли к барбекю",
                "Вы смогли завести приятную светскую беседу и нашли новых друзей",
                0, 0, -10,10);
        start_story.direction[0].direction[1].direction[1] = new Situation(
          "Вы подошли к группе людей у басейна",
          "Наступив на мокрую поверхность вы падаете в басейн,\n"
                +"чем поднимаете настроение толпе",
                0, 0, -10,20);
        start_story.direction[1] = new Situation(
                "совещание, босс доволен",
                "Сегодня будет совещание, меня неожиданно вызвали,"
                        + "есть сведения что \n босс доволен сегодняшней сделкой."
                        +"\n(Нажмите 1 чтобы продолжить)",
                1, 1, 100, 0);
        start_story.direction[1].direction[0] = new Situation(
                "Вы приходите на совещание",
                "(1)Сидеть тихо и внимателно слушать\n"
                +"(2)Проявить интузиазм и поучаствовать в совещании",
                2, 1, 100, 0);
        start_story.direction[1].direction[0].direction[0] = new Situation(
                "Оказывается вас позвали случайно!",
                "Но начальству понравилась ваше спокойствие в этой ситуации\n"
                        +" и успехи в прошлом проекте!",
                0, 1, 100, 5);
        start_story.direction[1].direction[0].direction[1] = new Situation(
                "Оказывается вас позвали случайно!",
                "Вы были уволены из фирмы за такую наглость",
                0, 1, 100, -100
        );
        start_story.direction[2] = new Situation(
                "мой первый лояльный клиент",
                "Мой первый клиент доволен скоростью и качеством "
                        + "моей работы. Сейчас мне звонил лично \nдиректор компании,  сообщил что скоро состоится еще более крупная сделка"
                        + " и он хотел, чтобы по ней работал именно я!\n"
                        +"(1)Отказаться и пойти спать\n"
                        +"(2)Согласиться и продолжить работать", 2, 0,
                50, 1);
        start_story.direction[2].direction[0] = new Situation(
                "Босс поставил на ваше место другого сотрудника!",
                "А вы уволины!!!!!!!!!!!!!!!",
                0, 0, 50, -100);
        start_story.direction[2].direction[1] = new Situation(
                "Вы взялись за новыю работу",
                "(1)Пойти поест\n"
                +"(2)Работать до конца",
                2, 0,50,1);
        start_story.direction[2].direction[1].direction[0] = new Situation(
                "Вы ели слишком долго и пропустил сделку",
                "Вы потеряли уважение начальства",
                0, 0,50, -10);
        start_story.direction[2].direction[1].direction[1] = new Situation(
                "Вы завершили проект в срок",
                "Но вы не ели более часа и скончались от голода...",
                0, 0, 50, 1000);
        current_situation = start_story;
    }
    public void go(int num) {
        if (num <= current_situation.direction.length)
            current_situation = current_situation.direction[num - 1];
        else
            System.out.println("Вы можете выбирать из "
                    + current_situation.direction.length + " вариантов");
    }
    public boolean isEnd() {
        return current_situation.direction.length == 0;
    }
}
