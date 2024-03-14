fun main() {
    MobilePhone("1111111111").apply {
        val Serg = Contact("Sergey", "89132906298")
        val Den = Contact("Denis", "89131397846")
        addNewContact(Serg)
        printContacts()
        updateContact(Serg, Den, UpdateType.All)
        printContacts()
        updateContact(Serg, Den, UpdateType.Name)
        printContacts()
        printContacts()
        queryContact(Serg.name)?.let(::println)
        findContact(Den).let(::println)
        removeContact(Den)
        printContacts()
        val leha = Contact("Arbuz", "123456789")
        addNewContact(leha)
        updateContact(leha.copy(name = "Lom"))
        printContacts()
    }
}
