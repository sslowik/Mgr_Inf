using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Fluent
{
    public class MeatPizza : PizzaBuilder
    {
        public MeatPizza()
        {
            pizza = new Pizza("Meat");
        }
        public override PizzaBuilder PrepareDough()
        {
            pizza["dough"] = "Thick";
            return this;
        }
        public override PizzaBuilder AddCheese()
        {
            pizza["cheese"] = "Mozarella and Parmezane";
            return this;
        }
        public override PizzaBuilder AddTopping()
        {
            pizza["topping"] = "Salami, Bacon and Sausages";
            return this;
        }
        public override PizzaBuilder AddSauce()
        {
            pizza["sauce"] = "Double Garlic";
            return this;
        }
    }
}
