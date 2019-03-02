(ns api.pet.database-test
  (:use [midje.sweet])
  (:require [api.pet.database :as pet-database]))

(facts "find-pets-by-user"
  (fact "user has pets"
    (pet-database/find-pets-by-user {:id 1}) => [{:id 1, :name "Tom", :user_id 1}, {:id 2, :name "Brigite", :user_id 1}])
  (fact "user has no pets"
    (pet-database/find-pets-by-user {:id 2}) => []))
