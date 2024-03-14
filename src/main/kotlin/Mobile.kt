import org.slf4j.LoggerFactory
import kotlin.random.Random
data class Contact(var name: String, var number: String, val id: Int = Random.nextInt())
class MobilePhone(myNumber: String) {
    private val myContacts = mutableListOf(Contact("Marusa", myNumber))
    fun addNewContact(newContact: Contact) = myContacts.add(newContact)
    fun updateContact(oldContact: Contact, newContact: Contact, type: UpdateType): Boolean {
        var isUpdated = false
        when (type) {
            UpdateType.All -> {
                isUpdated = myContacts.removeIf { it == oldContact }
                if (isUpdated) {
                    myContacts.add(newContact)
                }
            }
            UpdateType.Phone -> {
                val currentContact = queryContact(oldContact.name)
                if (currentContact != null) {
                    currentContact.number = newContact.number
                    isUpdated = true
                }
            }
            UpdateType.Name -> {
                val currentContact = queryContact(oldContact.name)
                if (currentContact != null) {
                    currentContact.name = newContact.name
                    isUpdated = true
                }
            }
        }
        return isUpdated
    }
    fun updateContact(newContact: Contact) {
        myContacts.replaceAll {
            if (it.id == newContact.id) newContact else it
        }
    }
    fun removeContact(contact: Contact) = myContacts.remove(contact)
    fun findContact(contact: Contact): Int = myContacts.indexOf(contact)
    fun queryContact(query: String): Contact? = myContacts.firstOrNull { it.name == query }
    fun printContacts() {
        myContacts.forEach {
            println(it)
            println('\n')
        }
        println("===================")
    }
}
enum class UpdateType {
    All, Phone, Name
}
