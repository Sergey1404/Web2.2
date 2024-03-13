fun main() {
    println("Mobile")
    val phone = MobilePhone("Anna", "89236092710")
    phone.addContact(Contact("Sveta", "89234562134"))
    phone.printContacts()
    print("\n")
    phone.updateContact(Contact("Sveta", "89234562134"), Contact("Svetlana", "89236912366"))

    phone.printContacts()
    println("index = ${phone.findContact(Contact("Dasha", "89231654782"))}")
    println("${phone.queryContact("Dasha")}")
}