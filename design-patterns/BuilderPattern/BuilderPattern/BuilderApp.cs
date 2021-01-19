using Fluent;
using System;

namespace BuilderPattern
{
    class BuilderApp
    {
        static void Main(string[] args)
        {
            Fluent.PizzaHouse pizzeria = new PizzaHouse();

            Pizza pizza = pizzeria.MakePizza(new VegePizzaBuilder());
            pizza.Bake();

            pizzeria.MakePizza(new MeatPizza()).Bake();
        }
    }
}
