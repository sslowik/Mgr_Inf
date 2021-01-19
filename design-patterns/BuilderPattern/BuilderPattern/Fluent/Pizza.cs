using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Fluent
{
    public class Pizza
    {
        private string _pizzaType;
        private Dictionary<string, string> _ingredients =
          new Dictionary<string, string>();

        public Pizza(string pizzaType) => this._pizzaType = pizzaType;

        public string this[string key]
        {
            get => _ingredients[key];
            set => _ingredients[key] = value;
        }

        public void Bake()
        {
            Console.WriteLine("\n---------------------------");
            Console.WriteLine($"Baking yummy {_pizzaType} Pizza . . .  ");
            Console.WriteLine($" #On {_ingredients["dough"]} dough,");
            Console.WriteLine($" #dressed with fresh topping: {_ingredients["topping"]},");
            Console.WriteLine($" #covered by delicious {_ingredients["cheese"]} cheese ");
            Console.WriteLine($" #and finished with aromatic {_ingredients["sauce"]} sauce.");
        }
    }
}
