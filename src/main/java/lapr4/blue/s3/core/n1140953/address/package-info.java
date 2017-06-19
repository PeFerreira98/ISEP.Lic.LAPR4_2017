/**
 * Technical documentation regarding the user story Core10.2.1- Address Edition<p>
 * <p>
 * <b>Attention: This feature increment and this documentation are work in
 * progress! </b><p>
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b><p>
 * <b>Area Leader: -(yes/no)- no</b><p>
 * <p>
 * <b>Requirement</b><p>
 * There should be a new sidebar window to create, edit and remove addresses 
 * associated with contacts (individuals or companies). <p>
 * Each address must include: street, town, postal code, city and country. <p>
 * Each contact should have to addresses: the main address and a secondary
 * address. <p>
 * In the case of a Portuguese address the postal code should be validated.<p>
 * It should be possible to import and update the the list of valid Portuguese 
 * postal codes from an external file (xml file or other format).<p>
 * <p>
 * <b>Design</b><p>
 * The following sequence diagram and class diagram represents this use case:
 * <p>
 * <img src="core_10_2_1_classDiagram.png" alt="image">
 * <p>
 * <p>
 * <img src="core_10_2_1_sequenceDiagram.png" alt="image">
 * <p>
 * <p>
 * <b>Classes</b><p>
 * {@link lapr4.blue.s3.core.n1140953.address.AddressController}<p>
 * {@link lapr4.blue.s3.core.n1140953.address.AddressExtension}<p>
 * {@link lapr4.blue.s3.core.n1140953.address.domain.Address}<p>
 * {@link lapr4.blue.s3.core.n1140953.address.persistence.AddressRepository}<p>
 * {@link lapr4.blue.s3.core.n1140953.address.persistence.jpa.JpaAddressRepository}<p>
 * {@link lapr4.blue.s3.core.n1140953.address.ui.AddContactAddressUI}<p>
 * {@link lapr4.blue.s3.core.n1140953.address.ui.AddressPanel}<p>
 * {@link lapr4.blue.s3.core.n1140953.address.ui.DeleteContactAddressUI}<p>
 * {@link lapr4.blue.s3.core.n1140953.address.ui.EditContactAddressUI}<p>
 * {@link lapr4.blue.s3.core.n1140953.address.ui.EditListContactAddressUI}<p>
 * {@link lapr4.blue.s3.core.n1140953.address.ui.UIAddressExtension}<p>
 * {@link lapr4.white.s1.core.n4567890.contacts.persistence.jpa.JpaRepositoryFactory} (changed)<p>
 * {@link lapr4.white.s1.core.n4567890.contacts.persistence.RepositoryFactory} (changed)<p>
 * <p>
 * <b>Unit Tests</b><p>
 * AddressTest<p>
 * <p>
 * <b>Work Log</b><p>
 * <b>Daily Log (Monday 12/06/2017) - </b>
 * Sprint2 closure. Start Sprint3 and Issues allocation.<p>
 *
 * <b>Daily Log (Tuesday 13/06/2017) - </b>
 * Starting use case Analysis and Design.<p>
 *
 * <b>Daily Log (Wednesday 14/06/2017) - </b>
 * Starting use case Implementation.<p>
 *
 * <b>Daily Log (Thursday 15/06/2017) - </b>
 * Continuing Analysis, Design and Implementation.<p>
 *
 * <b>Daily Log (Friday 16/06/2017) - </b>
 * Implementation partially done. Jpa Repository methods missing.<p>
 * 
 * <b>Daily Log (Sunday 18/06/2017) - </b>
 * Implementation done. Testing done. Design done. Analysis Done. Resolving Issue.<p>
 *
 * <b>Daily Log (Monday 19/06/2017) - </b><p>
 *
 *
 * @author pedroferreira(1140953)
 */
package lapr4.blue.s3.core.n1140953.address;
