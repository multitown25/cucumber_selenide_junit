Feature: authorization on the site and some clicks

  Scenario: logging in to site

    Given open kpfu.ru
    When press button by class "lk-link"
    And type to input with name "p_login" text: "RaRZinurov"
    And type to input with name "p_pass" text: "yu3zzlee"
    And press element with value "Отправить"
    Then element with name "Выход" should exist

  Scenario: go through personal account to schedule page

    Given open shelly.kpfu.ru/e-ksu/main_blocks.startpage
    When press button by text "Расписание"
    Then element by text "Мое расписание" should exist

  Scenario:
    Given open shelly.kpfu.ru/e-ksu/main_blocks.startpage
    When press button by text "Мой рейтинг"
    Then element by text "3 курс" should exist

  Scenario:
    Given open shelly.kpfu.ru/e-ksu/main_blocks.startpage
    When press button by title "Портфолио"
    Then element by class "value" should have text "Зинуров Рамазан Разябович"

  Scenario:
    Given open shelly.kpfu.ru/e-ksu/SITE_STUDENT_SH_PR_AC.offor_document?p_menu=14
    When press button by text "Документы"
    And press button by text "Шаблоны документов"
    And press button to download some file by xPath "//*[@id='tab1']/p[3]/a" should have text "Зинурова Рамазана Разябовича"

  Scenario:
    Given open shelly.kpfu.ru/e-ksu/new_stud_personal.stud_anketa
    When press button to download new photo
    Then element by class "photo" should exist
