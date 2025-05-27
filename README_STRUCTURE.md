# Структура Android приложения "Қазақ Әдебиеті"

## Обзор
Приложение создано на Java для Android и посвящено казахской литературе. Включает систему авторизации и главный экран с TabBar.

## Основные компоненты

### 1. Система авторизации
- **LoginActivity** - Экран входа/регистрации
- **activity_login.xml** - Layout для авторизации
- Поддерживает переключение между режимами входа и регистрации
- Сохраняет сессию пользователя в SharedPreferences

### 2. Главный экран с TabBar
- **MainActivity** - Основная активность с TabLayout и ViewPager
- **activity_main.xml** - Layout с Toolbar, TabLayout и ViewPager
- Два основных раздела: "Басты бет" и "AR"

### 3. Фрагменты
- **HomeFragment** - Главная страница с карточками разделов
- **ARFragment** - Раздел AR функциональности
- **fragment_home.xml** - Layout для главной страницы
- **fragment_ar.xml** - Layout для AR раздела

### 4. Навигация
- Стартовая активность: LoginActivity
- После авторизации: MainActivity с фрагментами
- Меню выхода в Toolbar

## Особенности

### Дизайн
- Material Design компоненты
- Современная цветовая палитра
- Карточки с градиентными фонами
- Адаптивный дизайн

### Локализация
- Весь интерфейс на казахском языке
- Тексты и сообщения переведены

### AR функциональность
- Заготовка для AR камеры
- AR галерея
- AR цитаты
- Пока что показывает Toast сообщения

## Файловая структура

```
app/src/main/
├── java/com/example/qazaqadebiety/
│   ├── LoginActivity.java
│   ├── MainActivity.java
│   └── fragments/
│       ├── HomeFragment.java
│       └── ARFragment.java
├── res/
│   ├── layout/
│   │   ├── activity_login.xml
│   │   ├── activity_main.xml
│   │   ├── fragment_home.xml
│   │   └── fragment_ar.xml
│   ├── drawable/
│   │   ├── ic_book.xml
│   │   ├── ic_ar.xml
│   │   └── ic_logout.xml
│   ├── menu/
│   │   └── main_menu.xml
│   └── values/
│       └── colors.xml
└── AndroidManifest.xml
```

## Тестовые данные для входа
- Email: admin@qazaq.kz
- Пароль: 123456

## Следующие шаги
1. Добавить реальную AR функциональность
2. Подключить базу данных
3. Добавить больше контента о казахской литературе
4. Улучшить дизайн и анимации 