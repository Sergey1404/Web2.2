import org.junit.jupiter.api.Test

class MobilePhoneTest {
    private val mobilePhone = MobilePhone( "89132906298")

    @Test
    fun addNewContact() {
        val contact = Contact("Denis", "89131397846")
        mobilePhone.addNewContact(contact)
    }

    @Test
    fun updateContact() {
        val old = Contact("Denis", "89131397846")
        val new = Contact("Den", "89234615735")
        mobilePhone.addNewContact(old)
        mobilePhone.updateContact(old, new, UpdateType.All)
        mobilePhone.queryContact("Den")
    }

    @Test
    fun removeContact() {
        val contact = Contact("Denis", "89131397846")
        mobilePhone.addNewContact(contact)
        mobilePhone.removeContact(contact)
        mobilePhone.queryContact("Denis")
    }

    @Test
    fun findContact() {
        val contact = Contact("Denis", "89131397846")
        mobilePhone.addNewContact(contact)
        mobilePhone.findContact(contact)
    }

    @Test
    fun queryContact() {
        val contact = Contact("Denis", "89131397846")
        mobilePhone.addNewContact(contact)
        mobilePhone.queryContact("Denis")
        mobilePhone.queryContact("Den")
    }
}
