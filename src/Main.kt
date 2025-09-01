fun main() {
    // 1. Define una clase Empleado(nombre, edad, salario, departamento)
    data class Empleado(val nombre: String, val edad: Int, val salario: Double, val departamento: String)

    // 2. Crea una lista de al menos 5 empleados
    val empleados = listOf(
        Empleado("Ana", 28, 45000.0, "IT"),
        Empleado("Carlos", 35, 52000.0, "Ventas"),
        Empleado("María", 31, 48000.0, "IT"),
        Empleado("Juan", 25, 38000.0, "Marketing"),
        Empleado("Laura", 42, 65000.0, "Ventas")
    )

    println("Lista de empleados:")
    for (empleado in empleados) {
        println("${empleado.nombre} - ${empleado.edad} años - ${empleado.salario} - ${empleado.departamento}")
    }

    // 3. Filtra los mayores de 30 años
    val mayoresDe30 = empleados.filter { it.edad > 30 }

    println("\nEmpleados mayores de 30 años:")
    for (empleado in mayoresDe30) {
        println("${empleado.nombre} - ${empleado.edad} años")
    }

    // 4. Agrúpalos por departamento
    val agrupados = empleados.groupBy { it.departamento }

    println("\nEmpleados agrupados por departamento:")
    for ((departamento, lista) in agrupados) {
        println("$departamento:")
        for (empleado in lista) {
            println("  ${empleado.nombre}")
        }
    }

    // 5. Calcula salario promedio por departamento
    println("\nSalario promedio por departamento:")
    for ((departamento, lista) in agrupados) {
        val totalSalarios = lista.map { it.salario }.sum()
        val promedio = totalSalarios / lista.size
        println("$departamento: $promedio")
    }

    // 6. Convierte la lista en un mapa nombre → salario
    val mapa = empleados.associateBy({ it.nombre }, { it.salario })

    println("\nMapa nombre → salario:")
    for ((nombre, salario) in mapa) {
        println("$nombre: $salario")
    }
}