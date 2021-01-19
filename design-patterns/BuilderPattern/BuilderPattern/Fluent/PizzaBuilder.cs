using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Fluent
{
    public abstract class PizzaBuilder
    {
        protected Pizza pizza;

        Pizza Bake => pizza;

        public abstract PizzaBuilder PrepareDough();
        public abstract PizzaBuilder AddCheese();
        public abstract PizzaBuilder AddTopping();
        public abstract PizzaBuilder AddSauce();

        public static implicit operator Pizza(PizzaBuilder pb) =>
            pb
                .PrepareDough()
                .AddCheese()
                .AddTopping()
                .AddSauce()
                .Bake;
    }
}
