1. Obiekty wartości (value objects)

- opakowujemy typy prymitywne w niemutowalne klasy z metodami biznesowymi
- dobrą praktyką jest utworzenie każdego konstruktora jako prywatnego, a tworzenie obiektu robić poprzez metody fabrykujące. Metody fabrykujące posiadają nazwę i dzięki temu możemy konstruować obiekt metodami o tej samej sygnaturze. Metoda fabrykująca ponad to pozwala zwrócić typ abstrakcyjny.
- dzięki obiektom wartości zyskujemy spójny język domenowy, a jakakolwiek zmiana logiki dotyczącej danej wartości ma miejsce tylko w tym obiekcie - nie musimy wszędzie szukać w kodzie wystąpień danego prymitywu lub Stringa.
- opakowanie innych obiektów innych klas typu BigDecimal lub klas dat pozwala nadać znaczenia biznesowego obiektowi