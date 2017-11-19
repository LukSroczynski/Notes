Istotne zmiany w Spring 5.0 ? 
Pierwszą zmianą jest zdecydowanie programowanie funkcjne z Kotlinem. Drugie to programowanie reaktywne.


Spring 5.0 - wstęp

W skrócie Spring jest to framework, który implementuje wzorzec Dependency Injection, czyli    
 
Istotne zmiany w Spring 5.0? 

- Core Container Update:

Czyli dodanie indeksacji dla komponentów. Zamiast używania classpath używamy indeksacji. W mniejszych projektach czyli takich co mają mniej niż 200 klas nie jest to istotna różnica. Ale w przypadku większych projektów jest to znacząca zmiana, gdyż czas budowania projektu pozostaje w takim wypadku stały. Możesz pomyśleć, że 10-30 sekund dziennie nie gra różnicy, ale pomnóż sobie ten czas razy kilkadziesiąt budowań w ciągu dnia i wychodzi całkiem duża spora liczba.  Użycie indeksacji pomoże ci zwiększyć swoją produktywność. Będziesz mógł się skupić bardziej na kodzie, aniżeli czekać kolejny raz na zbudowanie się projektu. 

Więcej tutaj:
https://jira.spring.io/browse/SPR-11890

- Wsparcie dla Kotlin’a

Szczerze powiedziawszy sam dopiero zaczynam przygodę z Kotlin’em, ale ma on dużą szansę zastąpić Javę na przestrzeni kolejnych lat. Można pisać kod Javy jednocześnie z kodem Kotlina. Jako rejestrację @Bean’ów możesz teraz używać Kotlina: 
val context = GenericApplicationContext {
registerBean()
registerBean { Cinema(it.getBean()) }
}

- Reaktywny Model Programowania

Kolejny buzz-word było programowanie funkcyjne teraz jest Programowanie Reaktywne. Znowu coś nowego…
Czyli co zapominamy już o funkcyjnym i przechodzimy teraz do reaktywnego! 
Niekoniecznie tak musi być. Programowanie funkcyjne uzupełnia programowanie reaktywne. Oczywiście możesz używać reaktywne ze starym paradygmatem, ale może to przyprawić o ból głowy i duże ilości boiler-code. 

WebFlux
https://docs.spring.io/spring-framework/docs/5.0.0.BUILD-SNAPSHOT/spring-framework-reference/html/web-reactive.html

 

 



