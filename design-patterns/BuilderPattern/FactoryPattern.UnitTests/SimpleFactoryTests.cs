namespace FactoryPattern.UnitTests
{
    using FactoryPattern.FactorySimple;
    using FactoryPattern.Model;
    using NUnit.Framework;
    using System;

    public class SimpleFactoryTests
    {
        private ChefMariano chef;

        [SetUp]
        public void Setup()
        {
            chef = ChefMariano.Instance;
        }

        [Test]
        public void CheckIfFactoryCreatesFoodWhenGivenCorrectNameTest()
        {
            var pizza = chef.PrepareDish("capriciosa");
            var pasta = chef.PrepareDish("bolognese");
            var drink = chef.PrepareDish("latte");

            Assert.That(pizza, Is.InstanceOf<Capriciosa>());
            Assert.That(pasta, Is.InstanceOf<BologneseSpaghetti>());
            Assert.That(drink, Is.InstanceOf<Coffee>());
        }

        [Test]
        public void CheckIfFactoryThrowsExceptionWhenGivenIncorrectNameTest()
        {
            Assert.Throws<ArgumentException>(() => chef.PrepareDish("tequila"));

            try
            {
                var alco = chef.PrepareDish("tequila");
            }
            catch (Exception e)
            {
                Assert.That(e is ArgumentException);
                Assert.That(e.Message.Contains("Try next week!"));
            }
        }
    }
}