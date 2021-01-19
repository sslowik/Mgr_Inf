using NUnit.Framework;
using Fluent;

namespace BuilderPatternUnitTests
{
    public class Tests
    {
        [SetUp]
        public void Setup()
        {
        }

        [Test]
        public void CheckIfPizzaIsCreatedAccordingToGivenBuilder()
        {
            PizzaHouse pizzeria = new PizzaHouse();

            Pizza pizza = pizzeria.MakePizza(new VegePizzaBuilder());
            pizza.Bake();

            pizzeria.MakePizza(new MeatPizza()).Bake();
            Assert.Pass();
        }

        [Test]
        public void CheckVegeBuilderPreparesPizzaWithExpectedIngredients()
        { 
        
        }

        [Test]
        public void CheckMeatBuilderPreparesPizzaWithExpectedIngredients()
        { }
    }
}