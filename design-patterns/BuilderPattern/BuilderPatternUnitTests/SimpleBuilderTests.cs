using Simple;
using NUnit.Framework;
using System.Collections.Generic;

namespace BuilderPatternUnitTests
{
    class SimpleBuilderTests
    {
        [SetUp]
        public void Setup()
        {
        }

        [Test]
        public void CheckBuildPizzaCreatesPizzaWithExpectedIngredientsTests()
        {
            var classic = new PizzaBuilder()
                .WithBecon()
                .WithGarlicSauce()
                .WithOlives()
                .Build();

            CollectionAssert.AreEqual(
                new List<string> { "crunchy becon", "aromatic garlic sauce", "juicy olives" },
                classic.Ingredients);
        }

        [TearDown]
        public void TearDown()
        {
        }

    }
}
