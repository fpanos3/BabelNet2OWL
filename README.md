# BabelNet2OWL

Aplicación para consulta en la red semántica BabelNet

Parte del Trabajo Fin de Máster 
Máster en Lenguajes y Sistemas Informáticos
Especialidad Tecnologías del Lenguaje en la Web

Título del TFM
Enriquecimiento semántico de ontologías de dominio
Experimentación en una ontología informática

CLASES

Sobres estas clases destacamos la Clase BabelNetENR.java que es la responsable del proceso completo de recuperación de los datos de la consulta originando una salida por consola en la que se muestras las líneas que realmente son los nodos y enlace de un grafo y que tienen la siguiente estructura,
Código Termino Origen - Termino Origen - Relación – Código termino destino - Termino Destino

En concreto la clase consulta por las cinco relaciones que se han definido en este proyecto, es decir por isA, isPartOf, hasPart, hasInstance y hasKind.

El resto de las otras  clases realizan las siguientes consultas,

•	BabelNetHypernyms.java, a partir de un ID de Synset proporcionado como parámetro, por ejemplo bn:00021464n, la consulta devuelve otras formas, es decir hiperónimos, del mismo término.
•	BabelNetRELhainstance.java, dado un parámetro como constructor de la consulta, por ejemplo "computer", ésta nos devuelve los términos que son hipónimos, pero solo aquellos que son instancias del concepto consultado
•	BabelNetRELhaskind.java, igual que la anterior pero solo los que son hipónimos.
•	BabelNetRELhaspart.java, igual que la anterior pero devolviendo los hipónimos
•	BabelNetRELisa.java, igual que la anterior pero devolviendo los hiperónimos
•	BabelNetRELpartof.java, igual que la anterior pero devolviendo los holónimos
•	BabelNetSense.java, a partir de un ID de un Synset, la consulta devuelve todos los objetos de BabelSense para este synset.
•	BabelNetSenseWikidata.java, igual que la anterior, pero seleccionando como fuente WikiData
•	BabelNetWord.java, igual que la anterior, pero seleccionando como fuente WordNet
•	BabelNetSynSetObjects.java, igual que las anteriores, recuperado todos los objetos de un synset
