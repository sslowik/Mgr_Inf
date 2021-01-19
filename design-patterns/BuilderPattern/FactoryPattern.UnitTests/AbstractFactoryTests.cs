namespace FactoryPattern.UnitTests
{
    using FactoryPattern.AbstractFactory;
    using FactoryPattern.Model;
    using NUnit.Framework;

    public class AbstractFactoryTests
    {
        [SetUp]
        public void Setup()
        {
        }

        [Test]
        public void CheckIfVegeFactoryReturnsVegeFoodTypeTest()
        {
            MarianoItalianoRestaurant chefMariano = new MarianoItalianoRestaurant(VegeMeal.Instance);

            var (pizza, pasta) = chefMariano.PrepareMeal();

            Assert.That(pizza, Is.InstanceOf<Margherita>());
            Assert.That(pasta, Is.InstanceOf<PestoSpaghetti>());
        }

        [Test]
        public void CheckIfMeatFactoryReturnsMeatFoodTypeTest()
        {
            MarianoItalianoRestaurant restaurant = new MarianoItalianoRestaurant(MeatMeal.Instance);

            var (pizza, pasta) = restaurant.PrepareMeal();

            Assert.That(pizza, Is.InstanceOf<Capriciosa>());
            Assert.That(pasta, Is.InstanceOf<BologneseSpaghetti>());
        }
    }
}
