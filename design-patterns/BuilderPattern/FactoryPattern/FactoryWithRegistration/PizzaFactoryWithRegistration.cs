namespace FactoryPattern.FactoryWithRegistration
{
    using System;
    using System.Collections.Generic;
    using FactoryPattern.Model;

    public class PizzaFactoryWithRegistration : GenericSingleton<PizzaFactoryWithRegistration>
    {
        private Dictionary<string, Func<APizza>> registeredTypes;

        private PizzaFactoryWithRegistration()
        {
            this.registeredTypes = new Dictionary<string, Func<APizza>>();
        }

        public APizza PreparePizza(string pizzaType)
        {
            if (!this.registeredTypes.ContainsKey(pizzaType))
            {
                throw new Exception($"Pizza {pizzaType} is not in menu. Sorry!");
            }

            return this.registeredTypes[pizzaType].Invoke();
        }

        public void Register(string pizzaType, Func<APizza> constructionMethod)
        {
            if (this.registeredTypes.ContainsKey(pizzaType))
            {
                throw new Exception($"Pizza: {pizzaType} is already in menu.");
            }

            this.registeredTypes[pizzaType] = constructionMethod;
        }
    }
}
