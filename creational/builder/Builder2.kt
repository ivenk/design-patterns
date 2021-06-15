/**
 * Optional in this example
 */
interface HousePlan {
    fun setBasement(basement: String)
    fun setStructure(structure: String)
    fun setRoof(roof: String)
}

/**
 * The object that is supposed to be build.
 */
class House : HousePlan {
    private var basement = ""
    private var structure = ""
    private var roof = ""

    override fun setRoof(roof: String) {
        this.roof = roof
    }

    override fun setBasement(basement: String) {
        this.basement = basement
    }

    override fun setStructure(structure: String) {
        this.structure = structure
    }
}

/**
 * The inteface for the different builders. Each builder builds one version of the target object
 */
interface HouseBuilder {
    fun buildBasement()
    fun buildStructure()
    fun buildRoof()
    fun getHouse(): House
}

/**
 * Example of a builder
 */
class IglooHouseBuilder : HouseBuilder {
    val construction = House()

    override fun buildBasement() {
        construction.setBasement("Ice")
    }

    override fun buildStructure() {
        construction.setStructure("Snow")
    }

    override fun buildRoof() {
        construction.setRoof("Snow")
    }

    override fun getHouse(): House {
        return construction
    }
}

/**
 * Example of a builder
 */
class NormalHouseBuilder : HouseBuilder {
    val construction = House()

    override fun buildBasement() {
        construction.setBasement("Stone")
    }

    override fun buildStructure() {
        construction.setStructure("Stone?")
    }

    override fun buildRoof() {
        construction.setRoof("RedThings")
    }

    override fun getHouse(): House {
        return construction
    }
}

/**
 * The director is the one actually using the builders to construct the target object.
 * The director maintains the order of the construction process.
 */
class BuildingDirector(private val houseBuilder: HouseBuilder) {
    fun build() : House {
        houseBuilder.buildBasement()
        houseBuilder.buildStructure()
        houseBuilder.buildRoof()
        return houseBuilder.getHouse()
    }
}


fun main() {
    println("Running main in Builder2.kt ...")

    val nHouse = BuildingDirector(NormalHouseBuilder()).build()
    val igloo = BuildingDirector(IglooHouseBuilder()).build()

}


