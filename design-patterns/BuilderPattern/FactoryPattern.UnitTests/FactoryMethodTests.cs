namespace FactoryPattern.UnitTests
{
    using FactoryPattern.FactoryMethods;
    using FactoryPattern.Model;
    using NUnit.Framework;

    public class FactoryMethodTests
    {
        [SetUp]
        public void Setup()
        {
        }

        [Test]
        public void CheckIfFactoryReturnsCorrectFoodTypeTest()
        {
            IPrepareFood factory;

            factory = MeatPizzaFactory.Instance;
            var meatPizza = factory.PrepareFood();
            factory = VegePizzaFactory.Instance;
            var vegePizza = factory.PrepareFood();

            Assert.That(meatPizza, Is.InstanceOf<Capriciosa>());
            Assert.That(vegePizza, Is.InstanceOf<Margherita>());
        }
    }
}