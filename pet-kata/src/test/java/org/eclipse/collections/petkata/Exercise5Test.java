/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.petkata;

import java.util.ArrayList;
import java.util.HashSet;

import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.block.predicate.Predicate;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.MutableDoubleList;
import org.eclipse.collections.api.partition.list.PartitionMutableList;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.test.Verify;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * In these tests, you will be able to discover some additional methods available on the Eclipse Collections API.
 *
 * {@link MutableList#partition(Predicate)}<br>
 * {@link PartitionMutableList#getSelected()}<br>
 * {@link PartitionMutableList#getRejected()}<br>
 * {@link MutableList#flatCollect(Function)}<br>
 * {@link MutableList#maxBy(Function)}<br>
 * {@link MutableList#collectDouble(DoubleFunction)}<br>
 * {@link MutableDoubleList#average()}<br>
 * {@link MutableList#collectInt(IntFunction)}<br>
 * {@link MutableBag#selectDuplicates()}<br>
 */
public class Exercise5Test extends PetDomainForKata
{
    @Test
    @Tag("KATA")
    public void partitionPetAndNonPetPeople()
    {
        PartitionMutableList<Person> partitionMutableList = null;
        Verify.assertSize(7, partitionMutableList.getSelected());
        Verify.assertSize(1, partitionMutableList.getRejected());
    }

    @Test
    @Tag("KATA")
    @DisplayName("getOldestPet - 🐶")
    public void getOldestPet()
    {
        Pet oldestPet = null;
        Assertions.assertEquals(PetType.DOG, oldestPet.getType());
        Assertions.assertEquals(4, oldestPet.getAge());
    }

    @Test
    @Tag("KATA")
    public void getAveragePetAge()
    {
        double averagePetAge = 0;
        Assertions.assertEquals(1.88888, averagePetAge, 0.00001);
    }

    @Test
    @Tag("KATA")
    public void addPetAgesToExistingSet()
    {
        // Hint: Use petAges as a target collection
        MutableIntSet petAges = IntSets.mutable.with(5);

        var expectedSet = IntSets.mutable.with(1, 2, 3, 4, 5);
        Assertions.assertEquals(expectedSet, petAges);
    }

    @Test
    @Tag("KATA")
    @DisplayName("findOwnerWithMoreThanOnePetOfTheSameType - 🐹 🐹")
    public void findOwnerWithMoreThanOnePetOfTheSameType()
    {
        /* Hint: find the owner with a short circuit detect . Use a predicate
        that utilizes Bags to find duplicates of a given pet type*/
        Person petOwner = null;

        Assertions.assertEquals("Harry Hamster", petOwner.getFullName());
        Assertions.assertEquals("🐹 🐹", petOwner.getPets().makeString(" "));
    }

    @Test
    @Tag("KATA")
    public void refactorToEclipseCollections()
    {
        Assertions.fail("Refactor to Eclipse Collections");

        // Replace List and ArrayList with Eclipse Collections types
        var people = new ArrayList<Person>();
        people.add(new Person("Mary", "Smith").addPet(PetType.CAT, "Tabby", 2));
        people.add(new Person("Bob", "Smith")
                .addPet(PetType.CAT, "Dolly", 3)
                .addPet(PetType.DOG, "Spot", 2));
        people.add(new Person("Ted", "Smith").addPet(PetType.DOG, "Spike", 4));
        people.add(new Person("Jake", "Snake").addPet(PetType.SNAKE, "Serpy", 1));
        people.add(new Person("Barry", "Bird").addPet(PetType.BIRD, "Tweety", 2));
        people.add(new Person("Terry", "Turtle").addPet(PetType.TURTLE, "Speedy", 1));
        people.add(new Person("Harry", "Hamster")
                .addPet(PetType.HAMSTER, "Fuzzy", 1)
                .addPet(PetType.HAMSTER, "Wuzzy", 1));
        people.add(new Person("John", "Doe"));

        // Replace Set and HashSet with Eclipse Collections types
        var petAges = new HashSet<Integer>();
        for (Person person : people)
        {
            for (Pet pet : person.getPets())
            {
                petAges.add(pet.getAge());
            }
        }

        //extra bonus - convert to a primitive collection
        var expectedSet = Sets.mutable.with(1, 2, 3, 4);
        Assertions.assertEquals(expectedSet, petAges, "Extra Credit - convert to a primitive collection");
    }
}
