# BonchBot
И так, мой юный друг. Проведем тебе небольшой гайд в царство плохого кода) 
Весь код можно разделить на несколько модулей. 
1. Служебный блок- Это классы VK..., CallBack и Messenger. 
  1.1 Серверный код- Классы Core И Server. 
      Core содержит код подгрузки конфига и код для приема нового сообщения(Нужен для LongPool версии, сейчас не используется).
      Server создает экземпляр Core и запускает бота.
  1.2 Manager. Набор методов для работы с пользователем. Получение инфы о нем(для LongPool ver), Отправки сообщений, постов и т.д.
    Messenger - база для сообщений
  1.3 CallBack- в версии API на момент разработки бота был забавный баг(...). В сообщении теперь приходит и инфа о юзере(в том числе, какие функции у него могут работать(клавиатура, карусель, колбек кнопки). Вытащить их можно только оттуда.
              Ирония в том, что встроенный в оф SDK, парсер не умеет парсить такие сообщения и падает, ломая бота. Пришлось наследоваться от класса и писать свой парсер.
2. Мадули. Тут лежат классы-обработчики(Command...) И базы элементные классы. 
  2.1 Обработчки- Из важного тут только класс CommandManager. Он содержит статический список всех команд бота. В этот список необходимо добавить команду из блока 3.
  В конструктор передается текст, при получении которого должны выполниться команда.
  2.2 Элементы. По папкам раскиданы все элементы управления ботом. 
    2.2.1 Клавиатуры- копипастный код. Все клавиатуры имеют общую архитектуру. Список всех кнопок. Кнопки 1 линии, 2 линии...
    В блоке статик нужно прописывать код добавления кнопок на каждую линию(в список пихать объект KeyboardButton с нужными параметрами)
    После чего все списки закинуть в allKey и их закинуть в клавиатуру. Теперь этот класс можно отправлять пользователю.
      2.2.1.2   inline клавы. Нужны для отправки колбек кнопок. Вся работа точно такая же как и с обычной клавой
   2.2.2 Карусели. Тут прописаны все базы. Для работы нужно отнаследовать новый элемент от BasicElements, новую карусель от BasicCarousel.
   В первом классе лежит логика заполнения заголовка элемента, описания, закидывания кнопок. Во втором в коллекцию итемов добавляются те, что ранее описывались.
3. Команды. Все команды должны наследоваться от Command. Интерфейс ServiceCommand. В методе exec описывается то, что болжно произойти при выполении команды. 
  В метод приходит само сообщение пользователя и инфа об отправителе. Как правило, В этом методе вызывается что то из VKManager для отправки ответа.
  
