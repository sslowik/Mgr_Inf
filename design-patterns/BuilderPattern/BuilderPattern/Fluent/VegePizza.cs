using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Fluent
{
    public class VegePizzaBuilder : PizzaBuilder
    {
        public VegePizzaBuilder()
        {
            pizza = new Pizza("Vege");
        }
        public override PizzaBuilder PrepareDough()
        {
            pizza["dough"] = "Unusually Thin";
            return this;
        }
        public override PizzaBuilder AddCheese()
        {
            pizza["cheese"] = "Little piece of Tofu ";
            return this;
        }
        public override PizzaBuilder AddTopping()
        {
            pizza["topping"] = "Ruccola and few Olives";
            return this;
        }
        public override PizzaBuilder AddSauce()
        {
            pizza["sauce"] = "Tomato without Salt";
            return this;
        }
    }
}
