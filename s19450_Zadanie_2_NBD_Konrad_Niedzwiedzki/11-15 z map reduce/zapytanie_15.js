var mapFunction = function() {
    if (this.nationality !== "Poland" || this.sex !== "Female")
        return;
    
    for (var i = 0; i < this.credit.length; i++)
        emit(this.credit[i].currency, this.credit[i].balance);
};

var reduce = function(key, values) {
    var sum = 0;
    for (var i = 0; i < values.length; i++) sum += values[i];
    return { summed_balance: sum, avg_balance: sum / values.length };
};

db.people.mapReduce(mapFunction, reduce, { out: 'poeple_female_pol_currency_remainings' });
var results = db.poeple_female_pol_currency_remainings.find({})
.toArray();
printjson(results)