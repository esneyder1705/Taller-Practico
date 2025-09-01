fun main() {
    // 1. Define una clase Empleado(nombre, edad, salario, departamento)
    data class Empleado(val nombre: String, val edad: Int, val salario: Double, val departamento: String)

    // 2. Crea una lista de al menos 5 empleados
    val empleados = listOf(
        Empleado("Juan David", 28, 45000.0, "IT"),
        Empleado("Berenice", 35, 52000.0, "Ventas"),
        Empleado("Amanda", 31, 48000.0, "IT"),
        Empleado("Luis Fernando", 25, 38000.0, "Marketing"),
        Empleado("Julian", 42, 65000.0, "Ventas"),
        Empleado("Sofía", 29, 47000.0, "IT"),
        Empleado("Carlos", 38, 54000.0, "Marketing"),
        Empleado("Ana María", 33, 49000.0, "Ventas"),
        Empleado("Diego", 27, 42000.0, "Marketing"),
        Empleado("Valeria", 30, 46000.0, "IT"),
        Empleado("Ricardo", 45, 68000.0, "Ventas"),
        Empleado("Gabriela", 26, 40000.0, "Marketing"),
        Empleado("Fernando", 34, 51000.0, "Ventas"),
        Empleado("Mariana", 28, 45000.0, "IT"),
        Empleado("Andrés", 39, 56000.0, "Marketing")
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
