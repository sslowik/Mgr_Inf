namespace FactoryPattern.UnitTests
{
    using FactoryPattern.FactoryWithRegistration;
    using FactoryPattern.Model;
    using NUnit.Framework;
    using System;

    public class FactoryWithReflectionTests
    {
        [SetUp]
        public void Setup()
        {
        }

        [Test]
        public void CheckIfFactoryPreparesGivenFoodTypeTest()
        {
            PastaFactoryWithReflection factory = PastaFactoryWithReflection.Instance;

            factory.Register("vegePasta", typeof(PestoSpaghetti));
            factory.Register("meatPasta", typeof(BologneseSpaghetti));

            var vege = factory.PreparePasta("vegePasta");
            var meat = factory.PreparePasta("meatPasta");

            Assert.That(vege, Is.InstanceOf<PestoSpaghetti>());
            Assert.That(meat, Is.InstanceOf<BologneseSpaghetti>());
        }

        [Test]
        public void CheckIfFactoryGivenIncorrectFoodNameThrowsExceptionTest()
        {
            Assert.Throws<Exception>(() => PizzaFactoryWithRegistration.Instance.PreparePizza("sushi"));
        }
    }
}