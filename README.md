## Trabajo practico especial Programacion 3

## Grupo 34

## Spacech Eduardo Matias espacech@alumnos.exa.unicen.edu.ar

## Teruggi Sergio Daniel steruggi@alumnos.exa.unicen.edu.ar

## Explicación de la estrategia de resolución del Backtracking

Cada nodo del árbol representa un estado parcial de solución: una lista de máquinas seleccionadas (solucionActual) y un número restante de piezas a producir (piezasRestantes).
En cada nivel del árbol:

    Se prueba agregar una máquina más de la lista maquinas.
    El algoritmo se mueve profundamente en el árbol, restando maquina.getPiezas() a piezasRestantes.

## Estados finales (hojas del árbol):

    Cuando piezasRestantes <= 0 o cuando ya no se desea seguir explorando (por poda).

## Estados solución:

    Cuando piezasRestantes == 0, es decir, la suma exacta de piezas ha sido lograda.

    Además, solo se guarda como solución óptima si la cantidad de máquinas usadas (solucionActual.size()) es menor que la solución actual almacenada.

## Posibles podas:

     Evitar combinaciones repetidas

##

##

## Explicación de la estrategia de resolución de Greedy

## Los candidatos son:

    Máquinas disponibles aún no seleccionadas

## Estrategia de seleccion de candidatos greedy

    Seleccionar la máquina con más piezas posible sin exceder tempPiezas

## Puede no encontrar solución

     Depende del conjunto de piezas y maquinas puede obtener solucion o no;
