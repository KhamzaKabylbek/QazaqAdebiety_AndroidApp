package com.example.qazaqadebiety.data;

import com.example.qazaqadebiety.model.Author;
import com.example.qazaqadebiety.model.LiteraryWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AuthorRepository {
    private static AuthorRepository instance;
    private List<Author> authors;
    private List<LiteraryWork> literaryWorks;

    private AuthorRepository() {
        initializeData();
    }

    public static AuthorRepository getInstance() {
        if (instance == null) {
            instance = new AuthorRepository();
        }
        return instance;
    }

    private void initializeData() {
        authors = new ArrayList<>();
        literaryWorks = new ArrayList<>();
        
        // Абай Кунанбаев
        authors.add(new Author(
            "Абай Құнанбайұлы",
            "Абай Құнанбайұлы",
            "Ұлы қазақ ақыны, философы, композиторы, ағартушы. Қазіргі қазақ жазба әдебиетінің негізін салушы.",
            "1845",
            "1904",
            "",
            Arrays.asList("Қара сөздер", "Ескендір", "Масғұт", "Татьянаның хаты"),
            Arrays.asList(
                "Адам болам десең, ауыз шешпе, қолың тосып тұрсын өзіңе.",
                "Үш нәрсе бар, ақылды адамды көрсететін: сабырлық, қанағатшылық, толағайлық.",
                "Ғылым таппай мақтанба, өнер таппай мақтанба."
            )
        ));

        // Мұхтар Әуезов
        authors.add(new Author(
            "Мұхтар Әуезов",
            "Мұхтар Омарханұлы Әуезов",
            "Дүниежүзілік деңгейдегі қазақ жазушысы, драматург, әдебиеттанушы. Атақты 'Абай жолы' романының авторы.",
            "1897",
            "1961",
            "",
            Arrays.asList("Абай жолы", "Қараш-Қараш оқиғасы", "Еңлік-Кебек"),
            Arrays.asList(
                "Адам ғылымды үйренуі керек.",
                "Еңбек етпеген адам ештеңеге жетпейді.",
                "Ақыл-ой дегеніміз - адамның ең бай қазынасы."
            )
        ));

        // Жамбыл Жабаев
        authors.add(new Author(
            "Жамбыл Жабайұлы",
            "Жамбыл Жабайұлы",
            "Дүниежүзілік танымал қазақ ақыны-импровизаторы, халық ақыны. Ауызша халық шығармашылығының шебері.",
            "1846",
            "1945",
            "",
            Arrays.asList("Ленинградтың балапандары", "Сүлеймен мен Қартқожа", "Утеген батыр"),
            Arrays.asList(
                "Мен жырлаймын мәңгі өмір сүру үшін.",
                "Ақын болсаң, егер де, жүрек терең болсын.",
                "Халқым үшін ән салам, халқым үшін өмір сүрем."
            )
        ));

        // Сәкен Сейфуллин
        authors.add(new Author(
            "Сәкен Сейфуллин",
            "Сәкен Сейфуллин",
            "Қазақ ақыны, жазушысы, қоғам қайраткері. Қазіргі қазақ әдебиетінің негізін салушылардың бірі.",
            "1894",
            "1938",
            "",
            Arrays.asList("Тар жол, тайғақ кеш", "Айша", "Қызыл қоса"),
            Arrays.asList(
                "Ғылым - арман бақытының кілті.",
                "Жастық шақтың қасиетті!",
                "Еңбек етпеген жерде бақыт болмас."
            )
        ));

        // Ілияс Есенберлин
        authors.add(new Author(
            "Ілияс Есенберлин",
            "Ілияс Есенберлин",
            "Дүниежүзілік танымал қазақ жазушысы, қазақ хандары мен батырлары туралы тарихи романдардың авторы.",
            "1915",
            "1983",
            "",
            Arrays.asList("Көшпенділер", "Жанталас", "Алмас қылыш"),
            Arrays.asList(
                "Тарих - халықтың жадында сақталған асыл мұра.",
                "Өткеннен сабақ алмаған халық болашағы қараң.",
                "Батырлық та, ақылдылық та дәстүрден басталады."
            )
        ));

        // Габит Мусрепов
        authors.add(new Author(
            "Ғабит Мүсірепов",
            "Ғабит Махмұтұлы Мүсірепов",
            "Қазақ жазушысы, драматургы, қоғам қайраткері. Қазақстанның халық жазушысы.",
            "1902",
            "1985",
            "",
            Arrays.asList("Ақан сері - Актоқты", "Өйткені оны жақсы көремін", "Қыран-Қыз"),
            Arrays.asList(
                "Ең үлкен байлық - жақсы адам тәрбиелеу.",
                "Ана тілі - халықтың жаны.",
                "Адамшылық дегеніміз - жақсылық жасау."
            )
        ));

        // Әдеби шығармаларды қосамыз
        initializeLiteraryWorks();
    }

    private void initializeLiteraryWorks() {
        literaryWorks.add(new LiteraryWork(
            "Абай жолы",
            "Абай жолы",
            "Мұхтар Әуезов",
            "Роман-эпопея",
            "1942-1956",
            "Ұлы қазақ ақыны Абай Құнанбайұлының өмірі мен шығармашылығы туралы монументалды шығарма",
            "Роман Абайдың өмірін, ақын және ойшыл ретінде қалыптасуын, XIX ғасырдағы қазақ қоғамын сипаттайды",
            true
        ));

        literaryWorks.add(new LiteraryWork(
            "Көшпенділер",
            "Көшпенділер",
            "Ілияс Есенберлин",
            "Тарихи трилогия",
            "1971-1976",
            "Қазақ хандығының құрылуы және оның алғашқы хандары туралы трилогия",
            "XV-XVI ғасырлардағы қазақ халқының тәуелсіздік үшін күресінің тарихы",
            true
        ));

        literaryWorks.add(new LiteraryWork(
            "Қара сөздер",
            "Қара сөздер",
            "Абай Құнанбайұлы",
            "Философиялық проза",
            "1890-1904",
            "Мораль, білім және рухани даму туралы 45 философиялық шығарма",
            "Ұлы ойшылдың дана ойлары мен ақыл-кеңестерінің жинағы",
            true
        ));
    }

    public List<Author> getAllAuthors() {
        return new ArrayList<>(authors);
    }

    public List<LiteraryWork> getAllLiteraryWorks() {
        return new ArrayList<>(literaryWorks);
    }

    public Author getAuthorByName(String name) {
        for (Author author : authors) {
            if (author.getName().equals(name) || author.getNameKazakh().equals(name)) {
                return author;
            }
        }
        return null;
    }

    public List<LiteraryWork> getWorksByAuthor(String authorName) {
        List<LiteraryWork> works = new ArrayList<>();
        for (LiteraryWork work : literaryWorks) {
            if (work.getAuthor().equals(authorName)) {
                works.add(work);
            }
        }
        return works;
    }

    public List<LiteraryWork> getClassicWorks() {
        List<LiteraryWork> classics = new ArrayList<>();
        for (LiteraryWork work : literaryWorks) {
            if (work.isClassic()) {
                classics.add(work);
            }
        }
        return classics;
    }
} 