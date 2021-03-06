package net.citizensnpcs.api.util.cuboid;

import java.util.ArrayList;
import java.util.List;

public class QuadNode {
    // We only hold the cuboids that fit completely inside of us.
    // Cuboids are always held in their minimal bounding node
    List<Cuboid> cuboids = new ArrayList<Cuboid>();

    // We only hold our list of cuboids, but to prevent duplicating lists and
    // having to climb to the root to find all of the cuboids that we need to
    // look
    // at
    // Point to the next highest node with cuboids to examine
    QuadNode nextListHolder;

    QuadNode parent = null;

    // children. Lower Left 0; Right + 1; Upper + 2
    /*
     * +0 |+1
     * +2 2 | 3
     * ------------
     * +0 0 | 1
     */
    QuadNode[] quads = new QuadNode[4];

    // Length of a side, always a power of two
    int size;

    // Indexed by least x and least z
    int x; // Traditional X in 2d

    int z; // What would be Y but this is minecraft

    QuadNode(int x, int z, int size, QuadNode parent) {
        this.x = x;
        this.z = z;
        this.size = size;
        this.parent = parent;
        if (parent == null) {
            return;
        }
        // If the parent is holding cuboids it is our next list holder
        if (parent.cuboids.size() != 0) {
            this.nextListHolder = parent;
        } else {// Otherwise whatever it's next list holder is is also ours
                // (even
                // null)
            this.nextListHolder = parent.nextListHolder;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof QuadNode)) {
            return false;
        }
        QuadNode n = (QuadNode) o;

        if (x != n.x || z != n.z || size != n.size) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return x ^ z ^ (~size);
    }

    @Override
    public String toString() {
        return "(" + x + "," + z + "; " + size + ")";
    }
}
