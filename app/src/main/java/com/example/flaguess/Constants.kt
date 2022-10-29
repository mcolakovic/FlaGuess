package com.example.flaguess

object Constants {

    const val USERNAME: String = "user_name"
    const val QUESTIONS: String = "total_questions"
    const val CORRECT:String = "correct_answers"


    fun getQuestions():ArrayList<Question?>{
        val questionsList = ArrayList<Question?>()

        val question1 = Question(1,
            "Kojoj državi pripada ova zastava?",
            R.drawable.jamajka,
            "Jamajka",
            "Jermenija",
            "Bolivija",
            "Etiopija",
            1
        )
        questionsList.add(question1)

        val question2 = Question(2,
            "Kojoj državi pripada ova zastava?",
            R.drawable.meksiko,
            "Bocvana",
            "Meksiko",
            "Kina",
            "Kamerun",
            2
        )
        questionsList.add(question2)

        val question3 = Question(3,
            "Kojoj državi pripada ova zastava?",
            R.drawable.svajcarska,
            "Kirgistan",
            "Kina",
            "Maroko",
            "Švajcarska",
            4
        )
        questionsList.add(question3)

        val question4 = Question(4,
            "Kojoj državi pripada ova zastava?",
            R.drawable.vijetnam,
            "Vijetnam",
            "Kina",
            "Crna Gora",
            "Japan",
            1
        )
        questionsList.add(question4)

        val question5 = Question(5,
            "Kojoj državi pripada ova zastava?",
            R.drawable.juznoafricka_republika,
            "Malezija",
            "Francuska",
            "Južnoafrička republika",
            "Etiopija",
            3
        )
        questionsList.add(question5)

        val question6 = Question(6,
            "Kojoj državi pripada ova zastava?",
            R.drawable.niger,
            "Nikaragva",
            "Niger",
            "Indija",
            "Portugal",
            2
        )
        questionsList.add(question6)

        val question7 = Question(7,
            "Kojoj državi pripada ova zastava?",
            R.drawable.slovacka,
            "Slovenija",
            "Slovačka",
            "Rusija",
            "Srbija",
            2
        )
        questionsList.add(question7)

        val question8 = Question(8,
            "Kojoj državi pripada ova zastava?",
            R.drawable.uganda,
            "Nepal",
            "Škotska",
            "Turska",
            "Uganda",
            4
        )
        questionsList.add(question8)

        val question9 = Question(9,
            "Kojoj državi pripada ova zastava?",
            R.drawable.saudijska_arabija,
            "Saudijska Arabija",
            "Pakistan",
            "Italija",
            "Brazil",
            1
        )
        questionsList.add(question9)

        val question10 = Question(10,
            "Kojoj državi pripada ova zastava?",
            R.drawable.urugvaj,
            "Rumunija",
            "Urugvaj",
            "Tunis",
            "Somalija",
            2
        )
        questionsList.add(question10)

        return questionsList
    }
}