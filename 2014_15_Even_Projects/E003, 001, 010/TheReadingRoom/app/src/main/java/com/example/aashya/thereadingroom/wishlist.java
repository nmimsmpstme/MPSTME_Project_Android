package com.example.aashya.thereadingroom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;


public class wishlist extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);


        databasemanager db = new databasemanager(this);

        int counter= 0;

        counter=db.getBooksCount();

        Log.d("COUNTER: ", " ="+ counter);

        if(counter<299) {
            Log.d("ADDING: ", "ENTERING");
            db.addBook(new books(1, "Otherbound", "Corinne Duyvis", "American Library"));
            db.addBook(new books(2, "Treaties, trenches, mud, and blood", "Nathan Hale", "American Library"));
            db.addBook(new books(3, "Curiosity", "Gary Blackwood", "American Library"));
            db.addBook(new books(4, "Absolutely almost", "Lisa Graff", "American Library"));
            db.addBook(new books(5, "The pilot and the Little Prince : the life of Antoine de Saint-Exupéry", "Peter Sís", "American Library"));
            db.addBook(new books(6, "Ida M. Tarbell : the woman who challenged big business--and won!", "Emily Arnold McCully", "American Library"));
            db.addBook(new books(7, "The pigeon needs a bath!", "Mo Willems", "American Library"));
            db.addBook(new books(8, "Queen Victoria's bathing machine", "Gloria Whelan", "American Library"));
            db.addBook(new books(9, "Anna & Solomon", "Elaine Snyder", "American Library"));
            db.addBook(new books(10, "The lucky one", "Nicholas Sparks", "American Library"));
            db.addBook(new books(11, "Twilight", "Stephenie Meyer", "American Library"));
            db.addBook(new books(12, "Eclipse", "Stephenie Meyer", "American Library"));
            db.addBook(new books(13, "Midnight's children", "Salman Rushdie", "American Library"));
            db.addBook(new books(14, "The catcher in the rye", "J. D. Salinger", "American Library"));
            db.addBook(new books(301, "The catcher in the rye", "J. D. Salinger", "British Library"));
            db.addBook(new books(15, "The color purple", "Alice Walker", "American Library"));
            db.addBook(new books(16, "The lion and the bird", "Marianne Dubuc", "American Library"));
            db.addBook(new books(17, "Outside in", "Sarah Ellis", "American Library"));
            db.addBook(new books(18, "Bombs over Bikini : the world's first nuclear disaster", "Connie Goldsmith", "American Library"));
            db.addBook(new books(19, "Violet Mackerel's possible friend", "Anna Branford", "American Library"));
            db.addBook(new books(20, "The Boundless", "Kenneth Oppel", "American Library"));
            db.addBook(new books(21, "Through the woods : stories", "Emily Carroll", "American Library"));
            db.addBook(new books(22, "The night gardener : a scary story", "Jonathan Auxier", "American Library"));
            db.addBook(new books(23, "Lulu's mysterious mission", "Judith Viorst", "American Library"));
            db.addBook(new books(24, "Fly away", "Patricia MacLachlan", "American Library"));
            db.addBook(new books(25, "Noggin", "John Corey Whaley", "American Library"));
            db.addBook(new books(26, "Separate is never equal : the story of Sylvia Mendez and her family's fight for desegregation", "Duncan Tonatiuh", "American Library"));
            db.addBook(new books(27, "The finest hours : the true story of a heroic sea rescue", "Michael J. Tougias", "American Library"));
            db.addBook(new books(28, "The slanted worlds", "Catherine Fisher", "American Library"));
            db.addBook(new books(29, "Found", "Salina Yoon", "American Library"));
            db.addBook(new books(30, "All different now : Juneteenth, the first day of freedom", "Angela Johnson", "American Library"));
            db.addBook(new books(31, "Screaming at the ump", "Audrey Vernick", "American Library"));
            db.addBook(new books(32, "Cold calls", "Charles Benoit", "American Library"));
            db.addBook(new books(33, "Everything leads to you", "Nina LaCour", "American Library"));
            db.addBook(new books(34, "Salvage", "Alexandra Duncan", "American Library"));
            db.addBook(new books(35, "The voice that challenged a nation : Marian Anderson and the struggle for equal rights", "Russell Freedman", "American Library"));
            db.addBook(new books(36, " Hostage", "Kay Hooper", "American Library"));
            db.addBook(new books(37, "Son of Sam case : Simon and Schuster Inc. v. members of New York State Crime Victims Board", "Susan Dudley Gold", "American Library"));
            db.addBook(new books(38, "Norman, speak!", "Caroline Adderson", "American Library"));
            db.addBook(new books(39, "I didn't do my homework because...", "Davide Cali", "American Library"));
            db.addBook(new books(40, "Upside down in the middle of nowhere", "Julie T. Lamana", "American Library"));
            db.addBook(new books(41, "Rules of summer", "Shaun Tan", "American Library"));
            db.addBook(new books(42, "An American army of two", "Janet Greeson", "American Library"));
            db.addBook(new books(43, "Jessica's x-ray", "Pat Zonta", "American Library"));
            db.addBook(new books(44, "Keep the lights burning, Abbie", "Peter Roop", "American Library"));
            db.addBook(new books(45, "Clementine, Friend of the Week", "Sara Pennypacker", "American Library"));
            db.addBook(new books(46, "The Berenstain bears and the truth", "Stan Berenstain", "American Library"));
            db.addBook(new books(47, "Scholastic's The magic school bus gets cold feet : a book about warm and cold-blooded animals", "Tracey West", "American Library"));
            db.addBook(new books(48, "The magic school bus gets baked in a cake : a book about kitchen chemistry", "Joanna Cole", "American Library"));
            db.addBook(new books(49, "Going over", "Beth Kephart", "American Library"));
            db.addBook(new books(50, "Always Emily : a novel of intrigue and romance", "Michaela MacColl", "American Library"));
            db.addBook(new books(51, "The girl and the bicycle", "Mark Pett", "American Library"));
            db.addBook(new books(52, "More of Monkey & Robot", "Peter Catalanatto", "American Library"));
            db.addBook(new books(53, "Also known as Elvis", "James Howe", "American Library"));
            db.addBook(new books(54, "Tyrannosaurus wrecks!", "Sudipta Bardhan-Quallen", "American Library"));
            db.addBook(new books(55, "The monkey goes bananas", "C.P. Bloom", "American Library"));
            db.addBook(new books(56, "How I discovered poetry", "Marilyn Nelson", "American Library"));
            db.addBook(new books(57, "Princess Sparkle-Heart gets a makeover", "Josh Schneider", "American Library"));
            db.addBook(new books(58, "The life of Ty : book 2 : non-random acts of kindness", "Lauren Myracle", "American Library"));
            db.addBook(new books(59, "The islands of Chaldea", "Diana Wynne Jones", "American Library"));
            db.addBook(new books(60, "Dragon of the red dawn : magic tree house series, #37", "Mary Pope Osborne", "American Library"));
            db.addBook(new books(61, "Chandra's magic light : a story in Nepal", "Theresa Heine", "American Library"));
            db.addBook(new books(62, "She is not invisible", "Marcus Sedgwick", "American Library"));
            db.addBook(new books(63, "Mr. Cornell's dream boxes", "Jeanette Winter", "American Library"));
            db.addBook(new books(64, "Jim Averbeck presents A Hitch at the Fairmont", "Jim Averbeck", "American Library"));
            db.addBook(new books(65, "He laughed with his other mouths", "M.T. Anderson", "American Library"));
            db.addBook(new books(66, "Gaston", "Kelly DiPucchio", "American Library"));
            db.addBook(new books(67, "The body in the woods", "April Henry", "American Library"));
            db.addBook(new books(68, "Love and other foreign words", "Erin McCahan", "American Library"));
            db.addBook(new books(69, "Mr. Pants : it's go time!", "Scott McCormick", "American Library"));
            db.addBook(new books(70, "Three bears in a boat", "David Soman", "American Library"));
            db.addBook(new books(71, "Frida & Diego : art, love, life", "Catherine Reef", "American Library"));
            db.addBook(new books(72, "If you're reading this", "Trent Reedy", "American Library"));
            db.addBook(new books(73, "The islands at the end of the world", "Austin Aslan", "American Library"));
            db.addBook(new books(74, "Elizabeth, queen of the seas", "Lynne Cox", "American Library"));
            db.addBook(new books(75, "Annika Riz, math whiz", "Claudia Mills", "American Library"));
            db.addBook(new books(76, "The Thickety : a path begins", "J.A. White", "American Library"));
            db.addBook(new books(77, "A southern girl : a novel", "John Warley", "American Library"));
            db.addBook(new books(78, "Promise land : my journey through America's self-help culture", "Jessica Lamb-Shapiro", "American Library"));
            db.addBook(new books(79, "Blame", "Michelle Huneven", "American Library"));
            db.addBook(new books(80, "This is the story of a happy marriage", "Ann Patchett", "American Library"));
            db.addBook(new books(81, "Queer : the ultimate LGBT guide for teens", "Kathy Belge", "American Library"));
            db.addBook(new books(82, "Drama high : the incredible true story of a brilliant teacher, a struggling town, and the magic of theater", "Michael Sokolove", "American Library"));
            db.addBook(new books(83, "Carrie", "Stephen King", "American Library"));
            db.addBook(new books(84, "Gray Mountain", "John Grisham", "American Library"));
            db.addBook(new books(85, "Bad blood", "John Sandford", "American Library"));
            db.addBook(new books(86, "Open : an autobiography", "Andre Agassi", "American Library"));
            db.addBook(new books(87, "Give me liberty : speakers and speeches that have shaped America", "Christopher L. Webber", "American Library"));
            db.addBook(new books(88, "Grandpa Green", "Lane Smith", "American Library"));
            db.addBook(new books(89, "Jim Henson : the biography", "Brian Jay Jones", "American Library"));
            db.addBook(new books(90, "The cabinet of curiosities : 36 tales brief & sinister", "Stefan Bachmann", "American Library"));
            db.addBook(new books(91, "Nuts to you", "Lynne Rae Perkins", "American Library"));
            db.addBook(new books(92, "Rough country", "John Sandford", "American Library"));
            db.addBook(new books(93, "Shock wave", "John Sandford", "American Library"));
            db.addBook(new books(94, "The storyteller : a novel", "Jodi Picoult", "American Library"));
            db.addBook(new books(95, "The associate", "John Grisham", "American Library"));
            db.addBook(new books(96, "American born Chinese", "Gene Luen Yang", "American Library"));
            db.addBook(new books(97, "Dark witch", "Nora Roberts", "American Library"));
            db.addBook(new books(98, "Diary of a wimpy kid : the long haul", "Jeff Kinney", "American Library"));
            db.addBook(new books(99, "Joyland", "Stephen King", "American Library"));
            db.addBook(new books(100, "The collectors", "David Baldacci", "American Library"));
            db.addBook(new books(101, "The checklist manifesto : how to get things right", "Atul Gawande", "American Library"));
            db.addBook(new books(102, "Mister Bud wears the cone", "Carter Goodrich", "American Library"));
            db.addBook(new books(103, "100 sideways miles", "Andrew Smith", "American Library"));
            db.addBook(new books(104, "Anybody shining", "Frances O'Roark Dowell", "American Library"));
            db.addBook(new books(105, "Give and take", "Chris Raschka", "American Library"));
            db.addBook(new books(106, "El deafo", "Cece Bell", "American Library"));
            db.addBook(new books(107, "The map trap", "Andrew Clements", "American Library"));
            db.addBook(new books(108, "Joltin' Joe DiMaggio", "Jonah Winter", "American Library"));
            db.addBook(new books(109, "The book with no pictures", "B.J. Novak", "American Library"));
            db.addBook(new books(110, "Circle of stones", "Catherine Fisher", "American Library"));
            db.addBook(new books(111, "Love is the drug", "Alaya Dawn Johnson", "American Library"));
            db.addBook(new books(112, "I know an old lady who swallowed a dreidel", "Caryn Yacowitz", "American Library"));
            db.addBook(new books(113, "Brown girl dreaming", "Jacqueline Woodson", "American Library"));
            db.addBook(new books(114, "As an oak tree grows", "G. Brian Karas", "American Library"));
            db.addBook(new books(115, "Always a catch", "Peter Richmond", "American Library"));
            db.addBook(new books(116, "The princess and the foal", "Stacy Gregg", "American Library"));
            db.addBook(new books(117, "The family Romanov : murder, rebellion & the fall of Imperial Russia", "Candace Fleming", "American Library"));
            db.addBook(new books(118, "Shh! We have a plan", "Chris Haughton", "American Library"));
            db.addBook(new books(119, "Vanilla ice cream", "Bob Graham", "American Library"));
            db.addBook(new books(120, "Fear the amoeba", "Jennifer L. Holm", "American Library"));
            db.addBook(new books(121, "The rise of Aurora West", "J.T. Petty", "American Library"));
            db.addBook(new books(122, "Four : a Divergent collection", "Veronica Roth", "American Library"));
            db.addBook(new books(123, "Mad River", "John Sandford", "American Library"));
            db.addBook(new books(124, "Twenty-two cents : Muhammad Yunus and the Village Bank", "Paula Yoo", "American Library"));
            db.addBook(new books(125, "The cat at the wall", "Deborah Ellis", "American Library"));
            db.addBook(new books(126, "Alexander, who's trying his best to be the best boy ever", "Judith Viorst", "American Library"));
            db.addBook(new books(127, "Ali : an American champion", "Barry Denenberg", "American Library"));
            db.addBook(new books(128, "Arctic thaw : climate change and the global race for energy resources", "Stephanie Sammartino McPherson", "American Library"));
            db.addBook(new books(129, "Santa Clauses : short poems from the North Pole", "Bob Raczka", "American Library"));
            db.addBook(new books(130, " Flashlight", "Lizi Boyd", "American Library"));
            db.addBook(new books(131, "The meaning of Maggie", "Megan Jean Sovern", "American Library"));
            db.addBook(new books(132, "Violet Mackerel's pocket protest", "Anna Branford", "American Library"));
            db.addBook(new books(133, "Cartwheeling in thunderstorms", "Katherine Rundell", "American Library"));
            db.addBook(new books(134, "Alligator & crocodile rescue : changing the future for endangered wildlife", "Trish Snyder", "American Library"));
            db.addBook(new books(135, "Mountains", "Peter Aleshire", "American Library"));
            db.addBook(new books(136, "Built to last", "David Macaulay", "American Library"));
            db.addBook(new books(137, "Battle hymn of the tiger mother", "Amy Chua", "American Library"));
            db.addBook(new books(138, "The hard bounce", "Todd Robinson", "American Library"));
            db.addBook(new books(139, "Saving grace", "Lee Smith", "American Library"));
            db.addBook(new books(140, "The big bang", "Paul Fleisher", "American Library"));
            db.addBook(new books(141, "Relativity", "Judith Herbst", "American Library"));
            db.addBook(new books(142, "Classification of life", "Melissa Stewart", "American Library"));
            db.addBook(new books(143, "Weather and climate", "Alvin Silverstein", "American Library"));
            db.addBook(new books(144, "Arab science and invention in the golden age", "Anne Blanchard", "American Library"));
            db.addBook(new books(145, "Robot", "Roger Bridgman", "American Library"));
            db.addBook(new books(146, "Atomic structure", "Rebecca L. Johnson", "American Library"));
            db.addBook(new books(147, "The demolished man", "Alfred Bester", "American Library"));
            db.addBook(new books(148, "The stars my destination", "Alfred Bester", "American Library"));
            db.addBook(new books(149, "Dune", "Frank Herbert", "American Library"));
            db.addBook(new books(150, "A whole new mind : moving from the information age to the conceptual age", "Daniel H. Pink", "American Library"));
            db.addBook(new books(151, "Education", "Felicity Allen", "British council"));
            db.addBook(new books(152, "Knowledge Management in Education", "Kogan page", "British council"));
            db.addBook(new books(153, "Does Education Matter?", "Alison Wolf", "British council"));
            db.addBook(new books(154, "Education and Society", "Rob Moore", "British council"));
            db.addBook(new books(155, "The Pratichi Education repot", "Amartya Sen", "British council"));
            db.addBook(new books(156, "Education,Education,Education:reforming England’s Schools", "Andrew Adonis", "British council"));
            db.addBook(new books(157, "Education and the education of teachers", "R.S.Peters", "British council"));
            db.addBook(new books(158, "Education in colonial Ceylon", "Kandy Kandy Printers 1962", "British council"));
            db.addBook(new books(159, "Key Issues in Education and Social Justice", "Dr. Emma Smith", "British council"));
            db.addBook(new books(160, "An education", "Scherfig lone", "British council"));
            db.addBook(new books(161, "Rescued", "McGraw Hill", "British council"));
            db.addBook(new books(162, "English For agribusiness and agriculture in higher education", "Robin Matheson", "British council"));
            db.addBook(new books(163, "Skills development in higher education and employment", "Bennett Neville", "British council"));
            db.addBook(new books(164, "Managing quality in higher education", "John Brennan", "British council"));
            db.addBook(new books(165, "Financial management and control in higher education", "Malcolm Prowie", "British council"));
            db.addBook(new books(166, "Achieving your doctorate in education", "Hilary Burgess", "British council"));
            db.addBook(new books(167, "Physical Education", "Ken Green and Ken Hardman", "British council"));
            db.addBook(new books(168, "Paren power", "Fracis Gilbert", "British council"));
            db.addBook(new books(170, "Making learning happen", "Phil Race", "British council"));
            db.addBook(new books(171, "An Education", "Nick Hornby", "British council"));
            db.addBook(new books(172, "India education report", "R. Govinda", "British council"));
            db.addBook(new books(173, "The Innovative University", "Clayton M. Christensen", "British council"));
            db.addBook(new books(174, "Making sense of Education", "David Carr", "British council"));
            db.addBook(new books(175, "The almanac of American education", "Lanham ", "British council"));
            db.addBook(new books(176, "WINDOWS POWERSHELL COOKBOOK", "Lee Holmes", "British council"));
            db.addBook(new books(177, "Beautiful Security Leading Secutrity", "Andy Oram", "British council"));
            db.addBook(new books(178, "Windows 7: Up and Running", "Wei-Meng Lee", "British council"));
            db.addBook(new books(179, "Windows Server 2008:The definitive guide", "Jonathan Hassell", "British council"));
            db.addBook(new books(180, "Windows Vista For Starters", "David Pogue", "British council"));
            db.addBook(new books(181, "Windows Vista in a Nutshell", "Pretson Gralla", "British council"));
            db.addBook(new books(182, "Active Directory", "Brian Desmond", "British council"));
            db.addBook(new books(183, "97 Things Every Project Manager should know", "Barbee Davis", "British council"));
            db.addBook(new books(184, "Software Engineering", "Ian Sommerville", "British council"));
            db.addBook(new books(185, "Software Engineering", "Roger S. Pressman", "British council"));
            db.addBook(new books(186, "Software Engineering", "Darrel Ince", "British council"));
            db.addBook(new books(187, "Software Engineering", "Mohaptra", "British council"));
            db.addBook(new books(188, "User Interface Design", "Lauesen Soren", "British council"));
            db.addBook(new books(189, "Software Engineering", "James F Peters and Witold Pedrycz", "British council"));
            db.addBook(new books(190, "Professional Software Engineering", "Steve McConnell", "British council"));
            db.addBook(new books(191, "Competitive Engineering", "Tom Gilb", "British council"));
            db.addBook(new books(192, "Object-Oriented Software Engineering", "Bernd Bruegge", "British council"));
            db.addBook(new books(193, "Software Engineering For Students", "Douglas Bell", "British council"));
            db.addBook(new books(194, "Software Engineering", "Hans Van Vliet", "British council"));
            db.addBook(new books(195, "Fundamentals of software engineering", "Rajib Mall", "British council"));
            db.addBook(new books(196, "Writing Essays", "Richard Maggraf Turley ", "British council"));
            db.addBook(new books(197, "How to Manage Your Arts, Humanities and Social Science Degree", "Lucinda Becker", "British council"));
            db.addBook(new books(198, "Effective communication for arts and humanities student", "Van Emden", "British council"));
            db.addBook(new books(199, "The Humanities", "Steohen Jay Gould", "British council"));
            db.addBook(new books(200, "Primary Humanities", "Tony Pickford", "British council"));
            db.addBook(new books(201, "The future without a past", "John Paul Russo ", "British council"));
            db.addBook(new books(202, "Progress in the humanities", "Volney Patrick Gay", "British council"));
            db.addBook(new books(203, "Pilgrims in medicine", "Thomas Alured Faunce", "British council"));
            db.addBook(new books(204, "Graduate study for the twenty-first century", "Gregory M.colon", "British council"));
            db.addBook(new books(205, "Why humanities matter", "Frederick luis Aldama", "British council"));
            db.addBook(new books(206, "The philosophy of law", "Garland", "British council"));
            db.addBook(new books(207, "The claim of language", "Christopher Fynsk", "British council"));
            db.addBook(new books(208, "Graham Greene", "Robert Hoskins", "British council"));
            db.addBook(new books(209, "Playboys and killjoys", "Harry levin", "British council"));
            db.addBook(new books(210, "Siblings under the skin", "Aurora", "British council"));
            db.addBook(new books(211, "Emile Durkheim", "Lacappra", "British council"));
            db.addBook(new books(212, "Samuel Beckett", "Steven connor", "British council"));
            db.addBook(new books(213, "Nothing but history", "David d. Roberts", "British council"));
            db.addBook(new books(214, "Humanities doctorates in the United states", "Linda Ingram", "British council"));
            db.addBook(new books(215, "Research Methods in Theatre and Performance", "Baz Kershaw", "British council"));
            db.addBook(new books(216, "Roman imperial statue bases", "Jakob Munk Hojte", "British council"));
            db.addBook(new books(217, "Empire’s Children", "M.Daphne Kutzer", "British council"));
            db.addBook(new books(218, "Translating for Children", "Riitta Oittinen", "British council"));
            db.addBook(new books(219, "Children’s films", "Ian Wojcik-Andrews", "British council"));
            db.addBook(new books(220, "The Pinter ethic", "Penelope Prentice", "British council"));
            db.addBook(new books(221, "Flash & amp;crash days", "David Sanderson George", "British council"));
            db.addBook(new books(222, "Rhetorical occasions", "Michael Berube", "British council"));
            db.addBook(new books(223, "Donal Bathelme", "Helen Moore barthelme", "British council"));
            db.addBook(new books(224, "Two natures met", "Jeannie Sargent Judge", "British council"));
            db.addBook(new books(225, "Gender and history in medieval English romance and chronicle", "Aurora", "British council"));
            db.addBook(new books(226, "On the dirty plate trail", "Sanora Babb", "British council"));
            db.addBook(new books(227, "Elloitt Carter", "John F. Link", "British council"));
            db.addBook(new books(228, "Goyen", "William Goyen", "British council"));
            db.addBook(new books(229, "Modern languages", "Alison M. Phipps", "British council"));
            db.addBook(new books(230, "Profits before people?", "Leonard J. Weber", "British council"));
            db.addBook(new books(231, "Nietzschean parody", "Sander L. Gillman", "British council"));
            db.addBook(new books(232, "Report to the academy", "Gregg  Lambert", "British council"));
            db.addBook(new books(233, "Plotinus on selfhood,freedom and politics", "Asger Ousager", "British council"));
            db.addBook(new books(234, "Medieval German literature", "Marion E. Gibbs", "British council"));
            db.addBook(new books(235, "Frederic Chopin", "William Smialek", "British council"));
            db.addBook(new books(236, "The collected poems and selected prose", "Stanley Burnshaw", "British council"));
            db.addBook(new books(237, "People of plenty", "David Morris Potter", "British council"));
            db.addBook(new books(238, "Surviving your academics job hunt", "Kathryn Hume", "British council"));
            db.addBook(new books(239, "The guide to Internet job searching", "Margaret F. Dikel", "British council"));
            db.addBook(new books(240, "How literature changes the way we think", "Michael Mack", "British council"));
            db.addBook(new books(241, "Human Nature:Fact and Fiction", "Robin Headlam-Wells", "British council"));
            db.addBook(new books(242, "Joseph Conrad", "Chris Fletcher", "British council"));
            db.addBook(new books(243, "Shakespear’s early comedies", "E.M.W Tillyard", "British council"));
            db.addBook(new books(244, "Row of lights:The story of Rama and Sita", "Lynne Broadbent", "British council"));
            db.addBook(new books(245, "Henry Fielding and the Augustan ideal", "Claude Rawson", "British council"));
            db.addBook(new books(246, "Reaserch methods for law", "Mike McConville and Wing hong Chui", "British council"));
            db.addBook(new books(247, "Demystifying postgraduate research:from MA to PhD", "Jonathon Grix", "British council"));
            db.addBook(new books(248, "Managing your academic careed: Universities into the 21st century", "Wyn Grant", "British council"));
            db.addBook(new books(249, "Cross-cultural marketing: Theory, Practice amd Relevance", "Dawn Burton", "British council"));
            db.addBook(new books(250, "For space", "Doreen Massey", "British council"));
            db.addBook(new books(251, "At The seaside", "Seek &  Sli Anker", "Colours library"));
            db.addBook(new books(252, "At The Park", "Seek & Sli Anker", "Colours library"));
            db.addBook(new books(253, "My First Numbers", "DK Tabular", "Colours library"));
            db.addBook(new books(254, "My First Words", "DK Tabular", "Colours library"));
            db.addBook(new books(255, "Teddy Bear Learning Stencils", "Bookmart", "Colours library"));
            db.addBook(new books(256, "Know Your Opposites", "Alka Publications ", "Colours library"));
            db.addBook(new books(257, "Know Your Things At Home", "Alka Publications", "Colours library"));
            db.addBook(new books(258, "Know Your Flags", "Alka Publications", "Colours library"));
            db.addBook(new books(259, "Know Your Sea Animals", "Alka Publications", "Colours library"));
            db.addBook(new books(260, "Know Your Safety", "Alka Publications", "Colours library"));
            db.addBook(new books(261, "Know Your Actions", "Alka Publications", "Colours library"));
            db.addBook(new books(262, "Know  Your Good Habits", "Alka Publications", "Colours library"));
            db.addBook(new books(263, "Know Your Vehicles", "Alka Publications", "Colours library"));
            db.addBook(new books(264, "Know Your Flowers", "Alka Publications", "Colours library"));
            db.addBook(new books(265, "Enjoy With Nursery Rhymes", "Alka Publications", "Colours library"));
            db.addBook(new books(266, "Who Said That", "Dial A Pict Playmore", "Colours library"));
            db.addBook(new books(267, "What Do I Eat", "Dial A Pict Playmore", "Colours library"));
            db.addBook(new books(268, "What  Do I Need", "Dial A Pict Playmore", "Colours library"));
            db.addBook(new books(269, "My Little Box Of Dinosaurs ", "Make Believe Ideas", "Colours library"));
            db.addBook(new books(270, "Beauties & Cuties", "Make Believe Ideas", "Colours library"));
            db.addBook(new books(271, "Handy Manny  My  First Library", "Disney", "Colours library"));
            db.addBook(new books(272, "Things That Go", "Make Believe  Ideas", "Colours library"));
            db.addBook(new books(273, "My First Box Of Books", "Make Ideas Believe", "Colours library"));
            db.addBook(new books(275, "Animal", "DK", "Colours library"));
            db.addBook(new books(276, "Phonics", "Dk", "Colours library"));
            db.addBook(new books(277, "Things That Go", "DK", "Colours library"));
            db.addBook(new books(278, "Abc", "DK", "Colours library"));
            db.addBook(new books(279, "Word", "DK", "Colours library"));
            db.addBook(new books(280, "Opposites", "DK", "Colours library"));
            db.addBook(new books(281, "Body", "DK", "Colours library"));
            db.addBook(new books(282, "Numbers", "DK", "Colours library"));
            db.addBook(new books(283, "Colours", "DK", "Colours library"));
            db.addBook(new books(284, "Jungle Animals", "Cupcake", "Colours library"));
            db.addBook(new books(285, "My Pets", "Cupcake", "Colours library"));
            db.addBook(new books(286, "Farm Animals", "Cupcake", "Colours library"));
            db.addBook(new books(287, "What Is That", "The Book Company", "Colours library"));
            db.addBook(new books(288, "My First Lift The Flap SBC", "Parragon", "Colours library"));
            db.addBook(new books(289, "Colours & Shapes", "Maple", "Colours library"));
            db.addBook(new books(290, "Flowers", "Maple", "Colours library"));
            db.addBook(new books(291, "Nursery Rhymes", "Maple", "Colours library"));
            db.addBook(new books(292, "Animals", "Maple", "Colours library"));
            db.addBook(new books(293, "Counting", "Maple", "Colours library"));
            db.addBook(new books(294, "Birds", "Maple", "Colours library"));
            db.addBook(new books(295, "Vegetables", "Maple", "Colours library"));
            db.addBook(new books(296, "Alphabets", "Maple", "Colours library"));
            db.addBook(new books(297, "Fruits", "Maple", "Colours library"));
            db.addBook(new books(297, "Baby Touch & Feel Playtime", "DK", "Colours library"));
            db.addBook(new books(298, "On The Farm", "Priddy Books", "Colours library"));
            db.addBook(new books(299, "Touch & Feel Cars", "Campbell books", "Colours library"));
            db.addBook(new books(300, "I Love Puppies", "Priddy Books", "Colours library"));
        }


        // search(s);
        db.close();

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.wish, menu);
        return true;

    }

    public void onclick1( View v)
    {

        Log.d("ADDING: ", "OnCreate qtya");
        //pass function
        Log.d("ADDING: ", "ENTERING");



    }

   // public void onclick2()
    //{
      //  databasemanager db = new databasemanager(this);
       // db.deletewish("HELL");
       // db.close();
   // }
}
