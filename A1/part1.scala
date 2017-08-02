def makePerson(n: String, a: Int) = {
	val name = () => n
	val age = () => a
	var vage = a
	def f_grow() = {
		vage = vage + 1
		(vage)
	}
	val grow = () => f_grow()
	(age, name, grow)
}

val (age, name, grow) = makePerson("Clark Kent", 28)
println(age())
println(name())
println(grow())
println(grow())
println(grow())