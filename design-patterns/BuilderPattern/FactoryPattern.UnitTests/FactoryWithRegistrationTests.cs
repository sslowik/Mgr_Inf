namespace FactoryPattern.UnitTests
{
    using FactoryPattern.FactoryWithRegistration;
    using FactoryPattern.Model;
    using NUnit.Framework;
    using System;

    public class FactoryWithRegistrationTests
    {
        [SetUp]
        public void Setup()
        {
        }

        [Test]
        public void CheckIfFactoryPreparesGivenFoodTypeTest()
        {
            PizzaFactoryWithRegistration factory = PizzaFactoryWithRegistration.Instance;

            factory.Register("meatPizza", () => new Capriciosa());
            factory.Register("vegePizza", () =>
            {
                return new Margherita
                {
                    WithOlive = true
                };
            });

            var meat = factory.PreparePizza("meatPizza");
            var vege = factory.PreparePizza("vegePizza");

            Assert.That(vege, Is.InstanceOf<Margherita>());
            Assert.That(meat, Is.InstanceOf<Capriciosa>());
        }

        [Test]
        public void CheckIfFactoryGivenIncorrectFoodNameThrowsExceptionTest()
        {
            Assert.Throws<Exception>(() => PizzaFactoryWithRegistration.Instance.PreparePizza("dumplings"));
        }
    }
}