namespace FactoryPattern.UnitTests
{
    using FactoryPattern.FactoryMethods;
    using FactoryPattern.FactorySimple;
    using FactoryPattern.FactoryWithRegistration;
    using FactoryPattern.Model;
    using NUnit.Framework;
    using System.Diagnostics;

    public class PerformanceTests
    {
        private ChefMariano simpleFactory;

        private IPrepareDrink coffeeFM;
        private IPrepareFood pizzaFM;

        private PizzaFactoryWithRegistration withRegistration;

        private PastaFactoryWithReflection withReflection;

        private static readonly int ITERATIONS = 10000000;

        [SetUp]
        public void Setup()
        {
            this.simpleFactory = ChefMariano.Instance;

            this.coffeeFM = CoffeeFactory.Instance;
            this.pizzaFM= VegePizzaFactory.Instance;

            this.withRegistration = PizzaFactoryWithRegistration.Instance;

            withRegistration.Register("meat", () => new Capriciosa());
            withRegistration.Register("vege", () => new Margherita());

            this.withReflection = PastaFactoryWithReflection.Instance;
            withReflection.Register("meatDish", typeof(BologneseSpaghetti));
            withReflection.Register("vegeDish", typeof(PestoSpaghetti));
        }

        [Test]
        public void CompareFactoryPerformanceTest()
        {
            var timer1 = Stopwatch.StartNew();
            for (int i = 0; i < ITERATIONS; i++)
            {
                var pizza = simpleFactory.PrepareDish("capriciosa");
                var coffee = simpleFactory.PrepareDish("latte");
            }

            timer1.Stop();
            var perfSimpleFactory = timer1.ElapsedMilliseconds;

            var timer2 = Stopwatch.StartNew();
            for (int i = 0; i < ITERATIONS; i++)
            {
                var coffee = coffeeFM.PrepareDrink();
                var pizza = pizzaFM.PrepareFood();
            }

            timer2.Stop();
            var perfFactoryMethod = timer2.ElapsedMilliseconds;

            var timer3 = Stopwatch.StartNew();
            for (int i = 0; i < ITERATIONS; i++)
            {
                var meat = withRegistration.PreparePizza("meat");
                var vege = withRegistration.PreparePizza("vege");
            }

            timer3.Stop();
            var perfWithRegistration = timer3.ElapsedMilliseconds;

            var timer4 = Stopwatch.StartNew();
            for (int i = 0; i < ITERATIONS; i++)
            {
                var meat = withReflection.PreparePasta("meatDish");
                var vege = withReflection.PreparePasta("vegeDish");
            }

            timer4.Stop();
            var perfWithReflection = timer4.ElapsedMilliseconds;

            TestContext.WriteLine($"Performance of methods after {ITERATIONS} iterations:");
            TestContext.WriteLine($"1. Factory Method:              [{perfFactoryMethod}    ms]");
            TestContext.WriteLine($"2. Factory Simple:              [{perfSimpleFactory}    ms]");
            TestContext.WriteLine($"3. Factory With Registration: [{perfWithRegistration} ms]");
            TestContext.WriteLine($"4. Factory With Reflection:   [{perfWithReflection}   ms]");

            Assert.That(perfWithRegistration, Is.LessThan(perfWithReflection));
            Assert.That(perfSimpleFactory, Is.LessThan(perfWithRegistration));
            Assert.That(perfFactoryMethod, Is.LessThan(perfSimpleFactory));
        }

        [TearDown]
        public void TearDown()
        {
            this.withReflection = null;
            this.withRegistration = null;
        }
    }
}