Podstawowe building blocki w programowaniu obiektowym

Obiekty wartości (value objects)

- opakowujemy typy prymitywne w niemutowalne klasy z metodami biznesowymi
- serwisowy, anemiczny kod przekształcamy w obiekty prezentujące zachowanie
- dobrą praktyką jest utworzenie każdego konstruktora jako prywatnego, a tworzyć obiekt należy poprzez metody fabrykujące. Posiadają nazwę i dzięki temu możemy konstruować obiekt za pomocą metod o tej samej sygnaturze. Metoda fabrykująca ponad to pozwala zwrócić typ abstrakcyjny.
- dzięki obiektom wartości zyskujemy spójny język domenowy, a jakakolwiek zmiana logiki dotyczącej danej wartości ma miejsce tylko w tym obiekcie - nie musimy wszędzie szukać w kodzie wystąpień danego prymitywu lub Stringa.
- opakowanie innych obiektów innych klas typu BigDecimal lub klas dat pozwala nadać znaczenia biznesowego obiektowi


Wrappery na kolekcje 

- każda kolekcja występująca w obiekcie jako jej pole powinna być opakowana w osobną klasę (lub inaczej jeśli w klasie występuje pole z kolekcją to nie powinno występować żadne inne pole)
- hermetyzujemy w ten sposób kolekcję, klient nie widzi co jest pod spodem i ma udostępniane zaprojektowane specjalnie pod niego metody biznesowe