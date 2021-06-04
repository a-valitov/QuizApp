package com.avalitov.quizapp

object Constants{

    // Global constants for activity interchange
    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANSWERS : String = "correct_answers"

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        // 1
        val que1 = Question(
            1, "Начнём с простого. Кто это?",
            R.drawable.dog_akita,
            "Акита-ину", "Чау-чау",
            "Лабрадор", "Кавказская овчарка", 1
        )

        questionsList.add(que1)

        // 2
        val que2 = Question(
            2, "А это что за хороший мальчик?",
            R.drawable.dog_samoed,
            "Лайка", "Хаски",
            "Самоед", "Пиренейская горная", 3
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
            3, "Может чмокнуть в ушко либо откусить лицо:",
            R.drawable.dog_bullterier,
            "Бульмастиф", "Бультерьер",
            "Бурбуль", "Английский бульдог", 2
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
            4, "Ладно, давайте посложнее. Кто это?",
            R.drawable.dog_kurtzhaar,
            "Курцхаар", "Далматинец",
            "Шотландский сеттер", "Английский пойнтер", 1
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
            5, "А кто вырастет из этого малыша?",
            R.drawable.dog_pitbool,
            "Бигль", "Дог",
            "Шарпей", "Питбуль", 4
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
            6, "Добавим немного экзотики. Кто тут у нас?",
            R.drawable.dog_basengi,
            "Басенджи", "Керн-терьер",
            "Ка-де-бо", "Хоккайдо", 1
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
            7, "А это что за принцесса?",
            R.drawable.dog_maltese,
            "Ши-тцу", "Мальтийская болонка",
            "Пудель", "Аркадий Укупник", 2
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
            8, "Это же этот, из рекламы!",
            R.drawable.dog_zennenhund,
            "Ньюфаундленд", "Фокстерьер",
            "Цвергшнауцер", "Зенненхунд", 4
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
            9, "Понятно, что шпиц, а какой?",
            R.drawable.dog_germanspitz,
            "Японский", "Померанский",
            "Немецкий", "Финский", 3
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
            10, "Машина для убийств с тихих европейских улочек, кто это?",
            R.drawable.dog_praha_krysarik,
            "Кёльнская мышарица", "Пражский крысарик",
            "Белградский хомякоед", "Ослинский выдрогрыз", 2
        )

        questionsList.add(que10)


        return questionsList
    }

}